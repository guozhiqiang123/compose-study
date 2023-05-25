-keepattributes Signature
-keepattributes Exceptions
-keepattributes *Annotation*

# Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }

# Gson
-dontwarn sun.misc.**
-keep class * extends com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}
-keep,allowobfuscation,allowshrinking class com.google.gson.reflect.TypeToken
-keep,allowobfuscation,allowshrinking class * extends com.google.gson.reflect.TypeToken



#保持数据DTO不被混淆
-keep interface com.gzq.wanandroid.core.http.BaseModel
-keep class com.gzq.wanandroid.core.http.HttpResult

-keep class com.gzq.wanandroid.model** {*;}


