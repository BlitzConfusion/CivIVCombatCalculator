# CivIVCombatCalculator-rakennekuvaus

Ohjelman Main:na toimii graafinen käyttöliittymä paketissaan.
Laskija-luokka on keskeisin laskutoimituksen tietojen pyörittelijä.
Kombinatooria kertoo kahden eri tapauksen luomien kombinaatioiden lukumäärän.
FSKombinatooria säilöö tietoa siitä, millä todennäköisyyksillä First Strike luo muutoksia asetelmaan.
Voimasuhde palauttaa tiedon tarvittavasta taistelun voiton kestosta ja osapuolten voimasuhteesta.

Kun käyttäjä (muutettuaan oletusparametreja halutessaan) painaa 'Calculate'-nappulaa, luodaan uusi Laskija-olio.
Laskija-olio siirtyy automaattisesti konstruktoristaan laskemaan saamillaan arvoilla. 
Tätä varten se luo uuden Voimasuhde-olion ja FSKombinatoorian, jolle annetaan myös kyseinen Voimasuhde-olio.
FSKombinatooria luo omia Kombinatoorioitaan auttamaan todennäköisyyksien muodostamisessa. 
Kombinatooria-tapaukset ovat sekä Laskijan että FSKombinatoorian alaisuudessa.
Kun Laskija on suorittanut laskunsa, käyttöliittymä poimii saadut oleelliset arvot, ja näyttää ne käyttäjälle.

Käyttäjä voi suorittaa Calculate-toiminnon eri inputeilla kuinka monta kertaa vain haluaa, tai sammuttaa ohjelman 'Close'-nappulalla.

Note: Ladatkaa .zip. Tämä ohjelma ei edellytä mitään erikoista, ja jostain syystä en ikinä ilmeisesti saanut osoitetta oikein Jar:ia varten.
