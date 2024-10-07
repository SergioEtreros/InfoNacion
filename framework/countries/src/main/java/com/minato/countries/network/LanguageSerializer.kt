package com.minato.countries.network

import com.minato.countries.network.model.Language
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.map

object LanguageSerializer : KSerializer<List<Language>> {
   override val descriptor: SerialDescriptor
      get() = ListSerializer(Language.serializer()).descriptor

   override fun serialize(
      encoder: Encoder,
      value: List<Language>
   ) {
   }

   override fun deserialize(decoder: Decoder): List<Language> {
      val jsonDecoder = decoder as? JsonDecoder ?: error("Debe usar JsonDecoder")
      val jsonElement = jsonDecoder.decodeJsonElement()
      if (jsonElement is JsonObject) {
         return jsonElement.map { (languageCode, languageElement) ->
            Language(
               languageCode = languageCode,
               name = languageElement.jsonPrimitive.content,
            )
         }
      } else {
         error("El formato del idioma no es el esperado")
      }
   }

}