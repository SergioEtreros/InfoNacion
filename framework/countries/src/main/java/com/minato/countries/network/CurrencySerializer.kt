package com.minato.countries.network

import com.minato.countries.network.model.Currency
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.map

object CurrencySerializer : KSerializer<List<Currency>> {
   override val descriptor: SerialDescriptor
      get() = ListSerializer(Currency.serializer()).descriptor

   override fun serialize(
      encoder: Encoder,
      value: List<Currency>
   ) {
   }

   override fun deserialize(decoder: Decoder): List<Currency> {
      val jsonDecoder = decoder as? JsonDecoder ?: error("Debe usar JsonDecoder")
      val jsonElement = jsonDecoder.decodeJsonElement()
      if (jsonElement is JsonObject) {
         return jsonElement.map { (currencyCode, currencyElement) ->
            val currencyObject =
               currencyElement.jsonObject
            Currency(
               currencyCode = currencyCode,
               name = currencyObject["name"]?.jsonPrimitive?.content ?: "",
               symbol = currencyObject["symbol"]?.jsonPrimitive?.content ?: ""
            )
         }
      } else {
         error("El formato de la moneda no es el esperado")
      }
   }
}