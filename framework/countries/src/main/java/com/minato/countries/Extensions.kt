package com.minato.countries

import com.minato.countries.database.CountryFull
import com.minato.countries.network.model.CountryItem
import com.minato.countries.network.model.Currencies
import com.minato.countries.network.model.Languages
import com.minato.countries.network.model.Translations
import com.minato.country.entities.Country
import com.minato.country.entities.Currency
import com.minato.country.entities.Language
import com.minato.country.entities.Translation
import com.minato.countries.database.entities.Country as DatabaseCountry
import com.minato.countries.database.entities.Currencies as DatabaseCurrencies
import com.minato.countries.database.entities.Languages as DatabaseLanguages
import com.minato.countries.database.entities.Translations as DatabaseTranslations

fun Currency.toDbModel(countryCode: String) = DatabaseCurrencies(
   currencyCode = code,
   countryCode = countryCode,
   name = name,
   symbol = symbol
)

fun Language.toDbModel(countryCode: String) = DatabaseLanguages(
   languageCode = languageCode,
   countryCode = countryCode,
   name = name,
)

fun Translation.toDbModel(countryCode: String) = DatabaseTranslations(
   languageCode = languageCode,
   countryCode = countryCode,
   official = official,
   common = common
)

fun DatabaseCountry.toDomainCountry() = Country(
   countryCode = countryCode,
   commonName = commonName,
   officialName = officialName,
   capital = capital,
   region = region,
   subregion = subregion,
   continent = continent,
   flag = flag,
   independent = independent,
   latitude = latitude,
   longitude = longitude,
   population = population,
   googleMaps = googleMaps,
   openStreetMaps = openStreetMaps,
   carSide = carSide,
   currencies = emptyList(),
   languages = emptyList(),
   translations = emptyList(),
   timeZones = emptyList(),
   borders = emptyList()
)

fun CountryFull.toDomainCountry() = Country(
   countryCode = country.countryCode,
   commonName = country.commonName,
   officialName = country.officialName,
   capital = country.capital,
   region = country.region,
   subregion = country.subregion,
   continent = country.continent,
   flag = country.flag,
   independent = country.independent,
   latitude = country.latitude,
   longitude = country.longitude,
   population = country.population,
   googleMaps = country.googleMaps,
   openStreetMaps = country.openStreetMaps,
   carSide = country.carSide,
   currencies = currencies?.map { Currency(it.currencyCode, it.name, it.symbol) } ?: emptyList(),
   languages = languages?.map { Language(it.languageCode, it.name) } ?: emptyList(),
   translations = translations?.map { Translation(it.languageCode, it.official, it.common) }
      ?: emptyList(),
   timeZones = timezones?.map { it.timeZone } ?: emptyList(),
   borders = borders?.map { it.borderCode } ?: emptyList()
)

fun Country.toDbModel() = DatabaseCountry(
   countryCode = countryCode,
   commonName = commonName,
   officialName = officialName,
   capital = capital,
   region = region,
   subregion = subregion,
   continent = continent,
   flag = flag,
   independent = independent,
   latitude = latitude,
   longitude = longitude,
   population = population,
   googleMaps = googleMaps,
   openStreetMaps = openStreetMaps,
   carSide = carSide
)

fun CountryItem.toDomainCountry() = Country(
   countryCode = cca2,
   commonName = name.common,
   officialName = name.official,
   capital = capital.firstOrNull() ?: "",
   region = region,
   subregion = subRegion,
   continent = continents.firstOrNull() ?: "",
   flag = flags.png,
   independent = independent,
   latitude = latlng.firstOrNull() ?: 0.0,
   longitude = latlng.lastOrNull() ?: 0.0,
   population = population,
   googleMaps = maps.googleMaps,
   openStreetMaps = maps.openStreetMaps,
   carSide = car.side,
   currencies = currencies?.getListOfCurrencies() ?: emptyList(),
   languages = languages?.getListOfLanguages() ?: emptyList(),
   translations = translations.getListOfTranslations(),
   timeZones = timezones,
   borders = borders
)

private fun Translations.getListOfTranslations(): List<Translation> {
   val translations = mutableListOf<Translation>()
   ara?.let { ara -> translations.add(Translation(::ara.name, ara.official, ara.common)) }
   bre?.let { bre -> translations.add(Translation(::bre.name, bre.official, bre.common)) }
   ces?.let { ces -> translations.add(Translation(::ces.name, ces.official, ces.common)) }
   cym?.let { cym -> translations.add(Translation(::cym.name, cym.official, cym.common)) }
   deu?.let { deu -> translations.add(Translation(::deu.name, deu.official, deu.common)) }
   eng?.let { eng -> translations.add(Translation(::eng.name, eng.official, eng.common)) }
   est?.let { est -> translations.add(Translation(::est.name, est.official, est.common)) }
   fin?.let { fin -> translations.add(Translation(::fin.name, fin.official, fin.common)) }
   fra?.let { fra -> translations.add(Translation(::fra.name, fra.official, fra.common)) }
   hrv?.let { hrv -> translations.add(Translation(::hrv.name, hrv.official, hrv.common)) }
   hun?.let { hun -> translations.add(Translation(::hun.name, hun.official, hun.common)) }
   ita?.let { ita -> translations.add(Translation(::ita.name, ita.official, ita.common)) }
   jpn?.let { jpn -> translations.add(Translation(::jpn.name, jpn.official, jpn.common)) }
   kor?.let { kor -> translations.add(Translation(::kor.name, kor.official, kor.common)) }
   nld?.let { nld -> translations.add(Translation(::nld.name, nld.official, nld.common)) }
   per?.let { per -> translations.add(Translation(::per.name, per.official, per.common)) }
   pol?.let { pol -> translations.add(Translation(::pol.name, pol.official, pol.common)) }
   por?.let { por -> translations.add(Translation(::por.name, por.official, por.common)) }
   rus?.let { rus -> translations.add(Translation(::rus.name, rus.official, rus.common)) }
   slk?.let { slk -> translations.add(Translation(::slk.name, slk.official, slk.common)) }
   spa?.let { spa -> translations.add(Translation(::spa.name, spa.official, spa.common)) }
   srp?.let { srp -> translations.add(Translation(::srp.name, srp.official, srp.common)) }
   swe?.let { swe -> translations.add(Translation(::swe.name, swe.official, swe.common)) }
   tur?.let { tur -> translations.add(Translation(::tur.name, tur.official, tur.common)) }
   urd?.let { urd -> translations.add(Translation(::urd.name, urd.official, urd.common)) }
   zho?.let { zho -> translations.add(Translation(::zho.name, zho.official, zho.common)) }

   return translations
}

private fun Languages.getListOfLanguages(): List<Language> {
   val languages = mutableListOf<Language>()
   if (ara.isNotBlank()) {
      languages.add(Language(::ara.name, ara))
   }
   if (bre.isNotBlank()) {
      languages.add(Language(::bre.name, bre))
   }
   if (ces.isNotBlank()) {
      languages.add(Language(::ces.name, ces))
   }
   if (cym.isNotBlank()) {
      languages.add(Language(::cym.name, cym))
   }
   if (deu.isNotBlank()) {
      languages.add(Language(::deu.name, deu))
   }
   if (eng.isNotBlank()) {
      languages.add(Language(::eng.name, eng))
   }
   if (est.isNotBlank()) {
      languages.add(Language(::est.name, est))
   }
   if (fin.isNotBlank()) {
      languages.add(Language(::fin.name, fin))
   }
   if (fra.isNotBlank()) {
      languages.add(Language(::fra.name, fra))
   }
   if (hrv.isNotBlank()) {
      languages.add(Language(::hrv.name, hrv))
   }
   if (hun.isNotBlank()) {
      languages.add(Language(::hun.name, hun))
   }
   if (ita.isNotBlank()) {
      languages.add(Language(::ita.name, ita))
   }
   if (jpn.isNotBlank()) {
      languages.add(Language(::jpn.name, jpn))
   }
   if (kor.isNotBlank()) {
      languages.add(Language(::kor.name, kor))
   }
   if (nld.isNotBlank()) {
      languages.add(Language(::nld.name, nld))
   }
   if (per.isNotBlank()) {
      languages.add(Language(::per.name, per))
   }
   if (pol.isNotBlank()) {
      languages.add(Language(::pol.name, pol))
   }
   if (por.isNotBlank()) {
      languages.add(Language(::por.name, por))
   }
   if (rus.isNotBlank()) {
      languages.add(Language(::rus.name, rus))
   }
   if (slk.isNotBlank()) {
      languages.add(Language(::slk.name, slk))
   }
   if (spa.isNotBlank()) {
      languages.add(Language(::spa.name, spa))
   }
   if (srp.isNotBlank()) {
      languages.add(Language(::srp.name, srp))
   }
   if (swe.isNotBlank()) {
      languages.add(Language(::swe.name, swe))
   }
   if (tur.isNotBlank()) {
      languages.add(Language(::tur.name, tur))
   }
   if (urd.isNotBlank()) {
      languages.add(Language(::urd.name, urd))
   }
   if (zho.isNotBlank()) {
      languages.add(Language(::zho.name, zho))
   }

   return languages
}

private fun Currencies.getListOfCurrencies(): List<Currency> {
   val currencies = mutableListOf<Currency>()
   ::sHP.name
   sHP?.let { sHP -> currencies.add(Currency(::sHP.name, sHP.name, sHP.symbol)) }
   aED?.let { aED -> currencies.add(Currency(::aED.name, aED.name, aED.symbol)) }
   aFN?.let { aFN -> currencies.add(Currency(::aFN.name, aFN.name, aFN.symbol)) }
   aLL?.let { aLL -> currencies.add(Currency(::aLL.name, aLL.name, aLL.symbol)) }
   aMD?.let { aMD -> currencies.add(Currency(::aMD.name, aMD.name, aMD.symbol)) }
   aNG?.let { aNG -> currencies.add(Currency(::aNG.name, aNG.name, aNG.symbol)) }
   aOA?.let { aOA -> currencies.add(Currency(::aOA.name, aOA.name, aOA.symbol)) }
   aRS?.let { aRS -> currencies.add(Currency(::aRS.name, aRS.name, aRS.symbol)) }
   aUD?.let { aUD -> currencies.add(Currency(::aUD.name, aUD.name, aUD.symbol)) }
   aWG?.let { aWG -> currencies.add(Currency(::aWG.name, aWG.name, aWG.symbol)) }
   aZN?.let { aZN -> currencies.add(Currency(::aZN.name, aZN.name, aZN.symbol)) }
   bAM?.let { bAM -> currencies.add(Currency(::bAM.name, bAM.name, bAM.symbol)) }
   bBD?.let { bBD -> currencies.add(Currency(::bBD.name, bBD.name, bBD.symbol)) }
   bDT?.let { bDT -> currencies.add(Currency(::bDT.name, bDT.name, bDT.symbol)) }
   bGN?.let { bGN -> currencies.add(Currency(::bGN.name, bGN.name, bGN.symbol)) }
   bHD?.let { bHD -> currencies.add(Currency(::bHD.name, bHD.name, bHD.symbol)) }
   bIF?.let { bIF -> currencies.add(Currency(::bIF.name, bIF.name, bIF.symbol)) }
   bMD?.let { bMD -> currencies.add(Currency(::bMD.name, bMD.name, bMD.symbol)) }
   bND?.let { bND -> currencies.add(Currency(::bND.name, bND.name, bND.symbol)) }
   bOB?.let { bOB -> currencies.add(Currency(::bOB.name, bOB.name, bOB.symbol)) }
   bRL?.let { bRL -> currencies.add(Currency(::bRL.name, bRL.name, bRL.symbol)) }
   bSD?.let { bSD -> currencies.add(Currency(::bSD.name, bSD.name, bSD.symbol)) }
   bTN?.let { bTN -> currencies.add(Currency(::bTN.name, bTN.name, bTN.symbol)) }
   bWP?.let { bWP -> currencies.add(Currency(::bWP.name, bWP.name, bWP.symbol)) }
   bYN?.let { bYN -> currencies.add(Currency(::bYN.name, bYN.name, bYN.symbol)) }
   bZD?.let { bZD -> currencies.add(Currency(::bZD.name, bZD.name, bZD.symbol)) }
   cAD?.let { cAD -> currencies.add(Currency(::cAD.name, cAD.name, cAD.symbol)) }
   cHF?.let { cHF -> currencies.add(Currency(::cHF.name, cHF.name, cHF.symbol)) }
   cLP?.let { cLP -> currencies.add(Currency(::cLP.name, cLP.name, cLP.symbol)) }
   cNY?.let { cNY -> currencies.add(Currency(::cNY.name, cNY.name, cNY.symbol)) }
   cOP?.let { cOP -> currencies.add(Currency(::cOP.name, cOP.name, cOP.symbol)) }
   cRC?.let { cRC -> currencies.add(Currency(::cRC.name, cRC.name, cRC.symbol)) }
   cUC?.let { cUC -> currencies.add(Currency(::cUC.name, cUC.name, cUC.symbol)) }
   cUP?.let { cUP -> currencies.add(Currency(::cUP.name, cUP.name, cUP.symbol)) }
   cVE?.let { cVE -> currencies.add(Currency(::cVE.name, cVE.name, cVE.symbol)) }
   cZK?.let { cZK -> currencies.add(Currency(::cZK.name, cZK.name, cZK.symbol)) }
   dJF?.let { dJF -> currencies.add(Currency(::dJF.name, dJF.name, dJF.symbol)) }
   dKK?.let { dKK -> currencies.add(Currency(::dKK.name, dKK.name, dKK.symbol)) }
   dOP?.let { dOP -> currencies.add(Currency(::dOP.name, dOP.name, dOP.symbol)) }
   dZD?.let { dZD -> currencies.add(Currency(::dZD.name, dZD.name, dZD.symbol)) }
   eGP?.let { eGP -> currencies.add(Currency(::eGP.name, eGP.name, eGP.symbol)) }
   eRN?.let { eRN -> currencies.add(Currency(::eRN.name, eRN.name, eRN.symbol)) }
   eTB?.let { eTB -> currencies.add(Currency(::eTB.name, eTB.name, eTB.symbol)) }
   eUR?.let { eUR -> currencies.add(Currency(::eUR.name, eUR.name, eUR.symbol)) }
   fJD?.let { fJD -> currencies.add(Currency(::fJD.name, fJD.name, fJD.symbol)) }
   fKP?.let { fKP -> currencies.add(Currency(::fKP.name, fKP.name, fKP.symbol)) }
   gBP?.let { gBP -> currencies.add(Currency(::gBP.name, gBP.name, gBP.symbol)) }
   gEL?.let { gEL -> currencies.add(Currency(::gEL.name, gEL.name, gEL.symbol)) }
   gHS?.let { gHS -> currencies.add(Currency(::gHS.name, gHS.name, gHS.symbol)) }
   gIP?.let { gIP -> currencies.add(Currency(::gIP.name, gIP.name, gIP.symbol)) }
   gMD?.let { gMD -> currencies.add(Currency(::gMD.name, gMD.name, gMD.symbol)) }
   gNF?.let { gNF -> currencies.add(Currency(::gNF.name, gNF.name, gNF.symbol)) }
   gTQ?.let { gTQ -> currencies.add(Currency(::gTQ.name, gTQ.name, gTQ.symbol)) }
   gYD?.let { gYD -> currencies.add(Currency(::gYD.name, gYD.name, gYD.symbol)) }
   hKD?.let { hKD -> currencies.add(Currency(::hKD.name, hKD.name, hKD.symbol)) }
   hNL?.let { hNL -> currencies.add(Currency(::hNL.name, hNL.name, hNL.symbol)) }
   hRK?.let { hRK -> currencies.add(Currency(::hRK.name, hRK.name, hRK.symbol)) }
   hTG?.let { hTG -> currencies.add(Currency(::hTG.name, hTG.name, hTG.symbol)) }
   hUF?.let { hUF -> currencies.add(Currency(::hUF.name, hUF.name, hUF.symbol)) }
   iDR?.let { iDR -> currencies.add(Currency(::iDR.name, iDR.name, iDR.symbol)) }
   iLS?.let { iLS -> currencies.add(Currency(::iLS.name, iLS.name, iLS.symbol)) }
   iNR?.let { iNR -> currencies.add(Currency(::iNR.name, iNR.name, iNR.symbol)) }
   iQD?.let { iQD -> currencies.add(Currency(::iQD.name, iQD.name, iQD.symbol)) }
   iRR?.let { iRR -> currencies.add(Currency(::iRR.name, iRR.name, iRR.symbol)) }
   iSK?.let { iSK -> currencies.add(Currency(::iSK.name, iSK.name, iSK.symbol)) }
   jMD?.let { jMD -> currencies.add(Currency(::jMD.name, jMD.name, jMD.symbol)) }
   jOD?.let { jOD -> currencies.add(Currency(::jOD.name, jOD.name, jOD.symbol)) }
   jPY?.let { jPY -> currencies.add(Currency(::jPY.name, jPY.name, jPY.symbol)) }
   kES?.let { kES -> currencies.add(Currency(::kES.name, kES.name, kES.symbol)) }
   kGS?.let { kGS -> currencies.add(Currency(::kGS.name, kGS.name, kGS.symbol)) }
   kHR?.let { kHR -> currencies.add(Currency(::kHR.name, kHR.name, kHR.symbol)) }
   kMF?.let { kMF -> currencies.add(Currency(::kMF.name, kMF.name, kMF.symbol)) }
   kPW?.let { kPW -> currencies.add(Currency(::kPW.name, kPW.name, kPW.symbol)) }
   kRW?.let { kRW -> currencies.add(Currency(::kRW.name, kRW.name, kRW.symbol)) }
   kWD?.let { kWD -> currencies.add(Currency(::kWD.name, kWD.name, kWD.symbol)) }
   kYD?.let { kYD -> currencies.add(Currency(::kYD.name, kYD.name, kYD.symbol)) }
   kZT?.let { kZT -> currencies.add(Currency(::kZT.name, kZT.name, kZT.symbol)) }
   lAK?.let { lAK -> currencies.add(Currency(::lAK.name, lAK.name, lAK.symbol)) }
   lBP?.let { lBP -> currencies.add(Currency(::lBP.name, lBP.name, lBP.symbol)) }
   lKR?.let { lKR -> currencies.add(Currency(::lKR.name, lKR.name, lKR.symbol)) }
   lRD?.let { lRD -> currencies.add(Currency(::lRD.name, lRD.name, lRD.symbol)) }
   lSL?.let { lSL -> currencies.add(Currency(::lSL.name, lSL.name, lSL.symbol)) }
   lTL?.let { lTL -> currencies.add(Currency(::lTL.name, lTL.name, lTL.symbol)) }
   lYD?.let { lYD -> currencies.add(Currency(::lYD.name, lYD.name, lYD.symbol)) }
   mAD?.let { mAD -> currencies.add(Currency(::mAD.name, mAD.name, mAD.symbol)) }
   mDL?.let { mDL -> currencies.add(Currency(::mDL.name, mDL.name, mDL.symbol)) }
   mGA?.let { mGA -> currencies.add(Currency(::mGA.name, mGA.name, mGA.symbol)) }
   mKD?.let { mKD -> currencies.add(Currency(::mKD.name, mKD.name, mKD.symbol)) }
   mMK?.let { mMK -> currencies.add(Currency(::mMK.name, mMK.name, mMK.symbol)) }
   mNT?.let { mNT -> currencies.add(Currency(::mNT.name, mNT.name, mNT.symbol)) }
   mOP?.let { mOP -> currencies.add(Currency(::mOP.name, mOP.name, mOP.symbol)) }
   mRO?.let { mRO -> currencies.add(Currency(::mRO.name, mRO.name, mRO.symbol)) }
   mUR?.let { mUR -> currencies.add(Currency(::mUR.name, mUR.name, mUR.symbol)) }
   mVR?.let { mVR -> currencies.add(Currency(::mVR.name, mVR.name, mVR.symbol)) }
   mWK?.let { mWK -> currencies.add(Currency(::mWK.name, mWK.name, mWK.symbol)) }
   mXN?.let { mXN -> currencies.add(Currency(::mXN.name, mXN.name, mXN.symbol)) }
   mYR?.let { mYR -> currencies.add(Currency(::mYR.name, mYR.name, mYR.symbol)) }
   mZN?.let { mZN -> currencies.add(Currency(::mZN.name, mZN.name, mZN.symbol)) }
   nAD?.let { nAD -> currencies.add(Currency(::nAD.name, nAD.name, nAD.symbol)) }
   nGN?.let { nGN -> currencies.add(Currency(::nGN.name, nGN.name, nGN.symbol)) }
   nIO?.let { nIO -> currencies.add(Currency(::nIO.name, nIO.name, nIO.symbol)) }
   nOK?.let { nOK -> currencies.add(Currency(::nOK.name, nOK.name, nOK.symbol)) }
   nPR?.let { nPR -> currencies.add(Currency(::nPR.name, nPR.name, nPR.symbol)) }
   nZD?.let { nZD -> currencies.add(Currency(::nZD.name, nZD.name, nZD.symbol)) }
   oMR?.let { oMR -> currencies.add(Currency(::oMR.name, oMR.name, oMR.symbol)) }
   pAB?.let { pAB -> currencies.add(Currency(::pAB.name, pAB.name, pAB.symbol)) }
   pEN?.let { pEN -> currencies.add(Currency(::pEN.name, pEN.name, pEN.symbol)) }
   pGK?.let { pGK -> currencies.add(Currency(::pGK.name, pGK.name, pGK.symbol)) }
   pHP?.let { pHP -> currencies.add(Currency(::pHP.name, pHP.name, pHP.symbol)) }
   pKR?.let { pKR -> currencies.add(Currency(::pKR.name, pKR.name, pKR.symbol)) }
   pLN?.let { pLN -> currencies.add(Currency(::pLN.name, pLN.name, pLN.symbol)) }
   pYG?.let { pYG -> currencies.add(Currency(::pYG.name, pYG.name, pYG.symbol)) }
   qAR?.let { qAR -> currencies.add(Currency(::qAR.name, qAR.name, qAR.symbol)) }
   rON?.let { rON -> currencies.add(Currency(::rON.name, rON.name, rON.symbol)) }
   rSD?.let { rSD -> currencies.add(Currency(::rSD.name, rSD.name, rSD.symbol)) }
   rUB?.let { rUB -> currencies.add(Currency(::rUB.name, rUB.name, rUB.symbol)) }
   rWF?.let { rWF -> currencies.add(Currency(::rWF.name, rWF.name, rWF.symbol)) }
   sAR?.let { sAR -> currencies.add(Currency(::sAR.name, sAR.name, sAR.symbol)) }
   sBD?.let { sBD -> currencies.add(Currency(::sBD.name, sBD.name, sBD.symbol)) }
   sCR?.let { sCR -> currencies.add(Currency(::sCR.name, sCR.name, sCR.symbol)) }
   sDG?.let { sDG -> currencies.add(Currency(::sDG.name, sDG.name, sDG.symbol)) }
   sEK?.let { sEK -> currencies.add(Currency(::sEK.name, sEK.name, sEK.symbol)) }
   sGD?.let { sGD -> currencies.add(Currency(::sGD.name, sGD.name, sGD.symbol)) }
   sLL?.let { sLL -> currencies.add(Currency(::sLL.name, sLL.name, sLL.symbol)) }
   sOS?.let { sOS -> currencies.add(Currency(::sOS.name, sOS.name, sOS.symbol)) }
   sRD?.let { sRD -> currencies.add(Currency(::sRD.name, sRD.name, sRD.symbol)) }
   sSP?.let { sSP -> currencies.add(Currency(::sSP.name, sSP.name, sSP.symbol)) }
   sYP?.let { sYP -> currencies.add(Currency(::sYP.name, sYP.name, sYP.symbol)) }
   sZL?.let { sZL -> currencies.add(Currency(::sZL.name, sZL.name, sZL.symbol)) }
   tHB?.let { tHB -> currencies.add(Currency(::tHB.name, tHB.name, tHB.symbol)) }
   tJS?.let { tJS -> currencies.add(Currency(::tJS.name, tJS.name, tJS.symbol)) }
   tMT?.let { tMT -> currencies.add(Currency(::tMT.name, tMT.name, tMT.symbol)) }
   tND?.let { tND -> currencies.add(Currency(::tND.name, tND.name, tND.symbol)) }
   tOP?.let { tOP -> currencies.add(Currency(::tOP.name, tOP.name, tOP.symbol)) }
   tRY?.let { tRY -> currencies.add(Currency(::tRY.name, tRY.name, tRY.symbol)) }
   tTD?.let { tTD -> currencies.add(Currency(::tTD.name, tTD.name, tTD.symbol)) }
   tWD?.let { tWD -> currencies.add(Currency(::tWD.name, tWD.name, tWD.symbol)) }
   tZS?.let { tZS -> currencies.add(Currency(::tZS.name, tZS.name, tZS.symbol)) }
   uAH?.let { uAH -> currencies.add(Currency(::uAH.name, uAH.name, uAH.symbol)) }
   uGX?.let { uGX -> currencies.add(Currency(::uGX.name, uGX.name, uGX.symbol)) }
   uSD?.let { uSD -> currencies.add(Currency(::uSD.name, uSD.name, uSD.symbol)) }
   uYU?.let { uYU -> currencies.add(Currency(::uYU.name, uYU.name, uYU.symbol)) }
   uZS?.let { uZS -> currencies.add(Currency(::uZS.name, uZS.name, uZS.symbol)) }
   vEF?.let { vEF -> currencies.add(Currency(::vEF.name, vEF.name, vEF.symbol)) }
   vND?.let { vND -> currencies.add(Currency(::vND.name, vND.name, vND.symbol)) }
   vUV?.let { vUV -> currencies.add(Currency(::vUV.name, vUV.name, vUV.symbol)) }
   wST?.let { wST -> currencies.add(Currency(::wST.name, wST.name, wST.symbol)) }
   xCD?.let { xCD -> currencies.add(Currency(::xCD.name, xCD.name, xCD.symbol)) }
   xOF?.let { xOF -> currencies.add(Currency(::xOF.name, xOF.name, xOF.symbol)) }
   xPF?.let { xPF -> currencies.add(Currency(::xPF.name, xPF.name, xPF.symbol)) }
   yER?.let { yER -> currencies.add(Currency(::yER.name, yER.name, yER.symbol)) }
   zAR?.let { zAR -> currencies.add(Currency(::zAR.name, zAR.name, zAR.symbol)) }
   zMW?.let { zMW -> currencies.add(Currency(::zMW.name, zMW.name, zMW.symbol)) }
   zWD?.let { zWD -> currencies.add(Currency(::zWD.name, zWD.name, zWD.symbol)) }

   return currencies

}

