package com.gzq.wanandroid.widget

import androidx.annotation.ColorInt
import androidx.annotation.Px
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gzq.wanandroid.R
import io.noties.markwon.AbstractMarkwonPlugin
import io.noties.markwon.Markwon
import io.noties.markwon.MarkwonConfiguration
import io.noties.markwon.core.MarkwonTheme
import io.noties.markwon.ext.strikethrough.StrikethroughPlugin
import io.noties.markwon.ext.tables.TableTheme
import io.noties.markwon.ext.tasklist.TaskListPlugin
import io.noties.markwon.html.HtmlPlugin
import io.noties.markwon.image.glide.GlideImagesPlugin
import io.noties.markwon.recycler.MarkwonAdapter
import io.noties.markwon.recycler.SimpleEntry
import io.noties.markwon.recycler.table.TableEntry
import io.noties.markwon.recycler.table.TableEntryPlugin
import io.noties.markwon.syntax.Prism4jThemeDefault
import io.noties.markwon.syntax.SyntaxHighlightPlugin
import io.noties.prism4j.Prism4j
import io.noties.prism4j.annotations.PrismBundle
import org.commonmark.ext.gfm.tables.TableBlock
import org.commonmark.node.FencedCodeBlock
import kotlin.math.roundToInt


@PrismBundle(
    includeAll = true,
    grammarLocatorClassName = ".GrammarLocatorSourceCode"
)
class GeneratePrism4j {

}

@Composable
fun Markdown(
    markdown: String,
    modifier: Modifier = Modifier,
    isDark: Boolean = isSystemInDarkTheme(),
    @ColorInt linkColor: Int = MaterialTheme.colorScheme.primary.toArgb(),
    @Px headingBreakHeight: Float = with(LocalDensity.current) { 2.dp.toPx() },
    @ColorInt blockQuoteColor: Int = MaterialTheme.colorScheme.outline.toArgb(),
    @ColorInt codeContainerColor: Int =
        if (isDark) MaterialTheme.colorScheme.secondaryContainer.toArgb()
        else MaterialTheme.colorScheme.onSecondaryContainer.toArgb(),
    @ColorInt codeColor: Int =
        if (isDark) MaterialTheme.colorScheme.onSecondaryContainer.toArgb()
        else MaterialTheme.colorScheme.secondaryContainer.toArgb(),
    @ColorInt tabBorderColor: Int = Color(0xFF262626).copy(alpha = 0.5f).toArgb(),
    @ColorInt tabHeadRowBackgroundColor: Int = MaterialTheme.colorScheme.secondary.toArgb(),
    @ColorInt tabEvenRowBackgroundColor: Int = Color.Transparent.toArgb(),
    @ColorInt tabOddRowBackgroundColor: Int = MaterialTheme.colorScheme.secondaryContainer.toArgb(),
    @Px tabBorderWidth: Float = with(LocalDensity.current) { 1.dp.toPx() },
    @ColorInt taskListCheckedFillColor: Int = MaterialTheme.colorScheme.primary.toArgb(),
    @ColorInt taskListNormalOutlineColor: Int = MaterialTheme.colorScheme.primary.toArgb(),
    @ColorInt taskListCheckMarkColor: Int = MaterialTheme.colorScheme.onPrimary.toArgb(),
) {
    val ctx = LocalContext.current


    val tabTheme = remember {
        TableTheme.Builder()
            .tableBorderColor(tabBorderColor)
            .tableBorderWidth(tabBorderWidth.roundToInt())
            .tableCellPadding(0)
            .tableHeaderRowBackgroundColor(tabHeadRowBackgroundColor)
            .tableEvenRowBackgroundColor(tabEvenRowBackgroundColor)
            .tableOddRowBackgroundColor(tabOddRowBackgroundColor)
            .build()
    }

    val markwon = remember {
        Markwon.builder(ctx)
            .usePlugin(TableEntryPlugin.create(tabTheme))
            .usePlugin(HtmlPlugin.create())
            .usePlugin(StrikethroughPlugin.create())
            .usePlugin(
                TaskListPlugin.create(
                    taskListCheckedFillColor,
                    taskListNormalOutlineColor,
                    taskListCheckMarkColor
                )
            )
            .usePlugin(GlideImagesPlugin.create(ctx))
            .usePlugin(
                SyntaxHighlightPlugin.create(
                    Prism4j(GrammarLocatorSourceCode()),
                    Prism4jThemeDefault.create(codeContainerColor)
                )
            )
            .usePlugin(object : AbstractMarkwonPlugin() {
                override fun configureTheme(builder: MarkwonTheme.Builder) {
                    builder.codeTextColor(codeColor)
                        .linkColor(linkColor)
                        .blockQuoteColor(blockQuoteColor)
                        .headingBreakHeight(headingBreakHeight.roundToInt())

                }

                override fun configureConfiguration(builder: MarkwonConfiguration.Builder) {

                }
            })
            .build()
    }

    val layoutManager = remember { LinearLayoutManager(ctx) }

    val adapter: MarkwonAdapter = remember {
        MarkwonAdapter.builderTextViewIsRoot(R.layout.markdown_root_node)
            .include(
                FencedCodeBlock::class.java,
                SimpleEntry.create(
                    R.layout.markdown_node_code_block,
                    R.id.text_view
                )
            )
            .include(TableBlock::class.java, TableEntry.create { builder ->
                builder
                    .tableLayout(
                        R.layout.markdown_node_table_block,
                        R.id.table_layout
                    )
                    .textLayoutIsRoot(R.layout.layout_table_entry_cell)
            })
            .build()
    }

    AndroidView(
        factory = {
            val recyclerView = RecyclerView(it)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
            recyclerView
        },
        modifier = modifier,
        update = {
            adapter.setMarkdown(markwon, markdown)
            adapter.notifyDataSetChanged()
        })
}