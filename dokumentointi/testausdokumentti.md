# CivIVCombatCalculator testausdokumentti

Testiluokkien täydentäminen tälle ohjelmalle on ollut sinänsä turhauttavaa, että koska käyttäjän input on rajattu Spinnereihin, 
ei käyttäjä kykene antamaan vääriä syötteitä, mikä osaltaan on poistanut tarpeen suurimmalle osalle tyypillisistä testeistä.
Tämän vuoksi testeissä on lähinnä keskitytty numeroidenpyörittelyn tarkkuuteen enemmänkin kuin varsinaisiin virhetilanteisiin.

Ohjelman käyttöliittymä on sen verran yksinkertainen, että sen erinäköisten tilojen läpikäynti on sinänsä helppoa,
ja koska ohjelman on tarkoitus simuloida Civilization IV:n taistelutodennäköisyys-infolaatikkoa, on myös yleinen tarkkuuden tarkistus helppoa
suoran vertailukohdan olemassaolon vuoksi. Testaus on siis ollut lähinnä manuaalista Spinnereiden pyörittelyä tiedettyjen tapausten 
ja toimintojen pohjalta.

Edellämainituista syistä testit joita tein ovat lähinnä satunnaismuuttujatestejä, joilla toistuvalla testauksella olen pyrkinyt
katsomaan, ettei mikään generoitu tapaus poikkea oletetusta.

Lähimmäksi ns. bugia CivIVCombatCalculator pääsee sillä, että rajoitetuilla kierroksilla voiton ja Withdrawal chance:n todennäköisyys
voi tietyillä syötteillä nousta 0.01 korkeammalle kuin 100(%). Tämä johtuu siitä, että valitulla kahden desimaalin esitystarkkuudella
kumpikin näistä voi pyöristyä ylöspäin.
