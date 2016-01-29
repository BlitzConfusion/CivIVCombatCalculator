# CivIVCombatCalculator
CivIVCombatCalculator on Civilization IV: Beyond the Sword pelin Taistelumekaniikan laskija,
jolla voi tarkistaa teoreettisia tilanteita ilman tarvetta ensin luoda vaikeasti alustettavia pelitilanteita,
tai teoreetisemmissa tapauksissa uusien hahmojen tai ominaisuuksien koodausta.
Koska kyseessä on epätriviaali määrä toistuvaa todennäköisyyslaskentaa, saattaa olla, että monimutkaisempi
lisäominaisuus kuten 'First Strike Chance' saattaa jäädä liian monimutkaisena implementoimatta.
'First Strike' yksinkertaisempana pyritään kuitenkin saamaan mukaan.

Tavoitteet:
1.0: Calculator laskee oikeat voiton todennäköisyydet perustaistelussa annettujen voimien perusteella.
1.0.1: Tapauksessa jossa annettu voima on korkeintaan 0, Calculator ilmoittaa skenaarion triviaaliksi.
1.1: Voimaan liittyvät bonukset implementoidaan.
1.2: 'First Strike':t (eli taisteluvuorot joilla omaajan häviö ei vaikuta) voidaan antaa voimien lisäksi.
1.3: 'Withdrawal Chance' lisätään mukaan.
1.4: Voi muokata kuinka paljon vahinkoa kullakin taisteluvuorolla aiheutetaan (tarpeen 'Air Combat':lle).
1.5: Rajoitettu taisteluvuoromäärä, implementoidaan. Yhdessä (1.4) kanssa tehty 'Air Combat'.

Lisätavoitteita:
2.0: Kerrotaan lisäksi todennäköisen voittajan keskimääräinen elämän määrä voitossa.
2.1: 'First Strike Chance' (eli vaihtuvasti on FS tai ei ole) implementoidaan.

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

First Strike Chance on kuin First Strike, mutta ei automaattinen. Jos osapuolella on 
0-2 First Strike Chance, kullakin 0-2 on 1/3 mahdollisuus. Eli ei 50% erillisiä testejä kullekin Chance:lle.
FSC on monimutkaisempi lisättävä, koska silloin muodostuu vastaava määrä skenaarioita jotka täytyy laskea
erikseen, ja näin laskea kokonaistodennäköisyys. Vielä vaikeampaa jos kummallakin osapuolella on FSC:ejä.

Calculatoriin oletetaan, että aiheutettu vahinko on 10%-100%, koska pelissä pienempi arvo veisi aikaa.
Lisäksi oletetaan että sekä First Strike on 0-5, First Strike Chance on 0-4.
Jos First Strike Chance:a ei implementoida, voidaan First Strike rajaus nostaa 10:een.

Graafinen käyttöliittymä on kolmiosainen lista, johon voi syöttää haluamansa arvot.
Painettaessa 'Simulate' saadaan eriteltynä voittotodennäköisyys, Withdrawal Chance,
ja mahdollisesti vielä voitossa keskimääräinen elämän määrä todennäköisellä voittajalla.


![Alt text](/BlitzConfusion/CivIVCombatCalculator/blob/master/Kaavio.png)
