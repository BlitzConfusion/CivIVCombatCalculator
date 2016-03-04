# CivIVCombatCalculator
AIHE: CivIVCombatCalculator on Civilization IV: Beyond the Sword pelin Taistelumekaniikan laskija,
jolla voi tarkistaa teoreettisia tilanteita ilman tarvetta ensin luoda vaikeasti alustettavia pelitilanteita,
tai teoreetisemmissa tapauksissa uusien hahmojen tai ominaisuuksien koodausta.
Koska kyseessä on epätriviaali määrä toistuvaa todennäköisyyslaskentaa, saattaa olla, että monimutkaisempi
lisäominaisuus kuten 'First Strike Chance' saattaa jäädä liian monimutkaisena implementoimatta.
'First Strike' yksinkertaisempana pyritään kuitenkin saamaan mukaan.

Tavoitteet:
1.0: Calculator laskee oikeat voiton todennäköisyydet perustaistelussa annettujen voimien perusteella.
1.1: Voimaan liittyvät bonukset implementoidaan.
1.2: 'First Strike':t (eli taisteluvuorot joilla omaajan häviö ei vaikuta) voidaan antaa voimien lisäksi.
1.3: 'Withdrawal Chance' lisätään mukaan.
1.4: Voi muokata kuinka paljon vahinkoa kullakin taisteluvuorolla aiheutetaan (tarpeen 'Air Combat':lle).
1.5: Rajoitettu taisteluvuoromäärä, implementoidaan. Yhdessä (1.4) kanssa tehty 'Air Combat'.
Tavoitteet saavutettu.

Lisätavoitteita:
2.0: Kerrotaan lisäksi todennäköisen voittajan keskimääräinen elämän määrä voitossa.
2.1: 'First Strike Chance' (eli vaihtuvasti on FS tai ei ole) implementoidaan.
Lisätavoitteita ei ole saavutettu.

Huomioita:
CivIV:ssä taistelu koostuu vuoroista joiden aikana kahden yksikön voimia verrataan, 
ja saadun suhteen todennäköisyydellä osapuoli voitettuaan aiheuttaa vahinkoa toiselle.
Aiheutettu vahinko ei vaikuta seuraavaan vuoroon, eli elämä ja voima eroteltava taistelun ajaksi.
Aiheutettu vahinko normaalisti 20% voittajan voimasta, voi muokata.

Withdrawal Chance on todennäköisyys, jolla häviössä hyökkääjä poistuu taistelusta kuoleman sijaan,
eli ensin pitää laskea häviön todennäköisyys, jotta Withdraw:n oikea todennäköisyys ilmenee.

First Strike on taisteluvuoro, jolla ainoastaan omaaja on immuuni vahingolle. Jotta vältettäisiin
turhat vuorot, First Strike:t vähennetään toisistaan vastakkaisilla osapuolilla.

Bonukset ovat voimaan lisäätäviä %-lisäyksiä. Toisin kuin voisi olettaa, CivIV:ssä vastustavat bonukset
vähennetään toisistaan suoraan.

Calculatoriin oletetaan, että aiheutettu vahinko on 20%-100% (aiemmin 10%-, mutta se aiheutti liikaa resurssien kannalta), koska pelissä pienempi arvo veisi aikaa.
Lisäksi oletetaan että sekä First Strike on 0-5.

Graafinen käyttöliittymä on kaksiosainen lista, johon voi syöttää haluamansa arvot.
Painettaessa 'Calculate' saadaan eriteltynä voittotodennäköisyys, Withdrawal Chance,
ja mahdollisesti vielä voitossa keskimääräinen elämän määrä todennäköisellä voittajalla.

KÄYTTÄJÄT: Pelaaja tai suunnittelija

KAIKKIEN KÄYTTÄJIEN TOIMINNOT: hahmojen olennaisten ominaisuuksien asettaminen. Yleisten olosuhteiden asettaminen. Näiden perusteella tapahtuvan taistelun lopputuloksen laskemisen käynnistäminen.

## Luokkakaavio

![Alt text](https://github.com/BlitzConfusion/CivIVCombatCalculator/blob/master/Kaavio.png)

## Sekvenssikaavio
![Alt text](https://github.com/BlitzConfusion/CivIVCombatCalculator/dokumentointi/CivIVCombatCalculator.png )

