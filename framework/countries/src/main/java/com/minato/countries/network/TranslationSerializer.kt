package com.minato.countries.network

import com.minato.countries.network.model.Translation
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object TranslationSerializer : KSerializer<List<Translation>> {
   override val descriptor: SerialDescriptor
      get() = ListSerializer(Translation.serializer()).descriptor

   override fun serialize(
      encoder: Encoder,
      value: List<Translation>
   ) {
   }

   override fun deserialize(decoder: Decoder): List<Translation> {
      val jsonDecoder = decoder as? JsonDecoder ?: error("Debe usar JsonDecoder")
      val jsonElement = jsonDecoder.decodeJsonElement()
// `jsonElement` es el nodo `translations` que contiene un objeto de objetos
      if (jsonElement is JsonObject) {
         return jsonElement.map { (languageCode, translationElement) ->
            val translationObject =
               translationElement.jsonObject
            Translation(
               languageCode = languageCode,
               official =
               translationObject["official"]?.jsonPrimitive?.content ?: "",
               common =
               translationObject["common"]?.jsonPrimitive?.content ?: ""
            )
         }
      } else {
         error("El formato de las traducciones no es el esperado")
      }
   }
}