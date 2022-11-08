package com.gzq.wanandroid.widget


import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntSize
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.bumptech.glide.request.transition.Transition
import com.gzq.wanandroid.core.glide.GlideApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun GlideImage(
    model: Any?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    alignment: Alignment = Alignment.Center,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    onImageReady: (() -> Unit)? = null,
    customize: RequestBuilder<Bitmap>.() -> RequestBuilder<Bitmap> = { this },
) {
    BoxWithConstraints {
        var image by remember { mutableStateOf<ImageBitmap?>(null) }
        var drawable by remember { mutableStateOf<Drawable?>(null) }
        val context = LocalContext.current

        DisposableEffect(key1 = model, effect = {
            val glide = GlideApp.with(context)
            var target: CustomTarget<Bitmap>? = null
            val job = CoroutineScope(Dispatchers.Main).launch {
                target = object : CustomTarget<Bitmap>() {
                    override fun onLoadCleared(placeholder: Drawable?) {
                        image = null
                        drawable = placeholder
                    }

                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?,
                    ) {
                        image = resource.asImageBitmap()
                        onImageReady?.invoke()
                    }
                }

                val size = constraints.run {
                    IntSize(
                        if (maxWidth in 1 until Int.MAX_VALUE) maxWidth else SIZE_ORIGINAL,
                        if (maxHeight in 1 until Int.MAX_VALUE) maxHeight else SIZE_ORIGINAL
                    )
                }

                glide
                    .asBitmap()
                    .load(model)
                    .override(size.width, size.height)
                    .let(customize)
                    .into(target!!)
            }

            onDispose {
                image = null
                drawable = null
                glide.clear(target)
                job.cancel()
            }
        })

        ActiveImage(
            image = image,
            drawable = drawable,
            modifier = modifier,
            contentScale = contentScale,
            alignment = alignment,
            alpha = alpha,
            colorFilter = colorFilter
        )
    }
}

@Composable
private fun ActiveImage(
    image: ImageBitmap?,
    drawable: Drawable?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
    alignment: Alignment = Alignment.Center,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    if (image != null) {
        Image(
            bitmap = image,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
            alignment = alignment,
            alpha = alpha,
            colorFilter = colorFilter
        )
    } else if (drawable != null) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .then(modifier)
        ) {
            drawIntoCanvas { drawable.draw(it.nativeCanvas) }
        }
    }
}
