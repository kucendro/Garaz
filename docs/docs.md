/**
 * Dokumentace k programu Garaz:
 *
 * Tento program implementuje správu garáže s využitím objektově orientovaného přístupu.
 * 
 * 1. **Rozbor implementace a porovnání efektivity:**
 *    - Zvolená implementace využívá strukturovaný přístup s důrazem na čitelnost a modularitu.
 *    - Efektivita této implementace je porovnána s dalšími dvěma přístupy:
 *      a) Procedurální přístup: Tento přístup by mohl být méně čitelný a obtížněji udržovatelný,
 *         zejména při větším rozsahu kódu.
 *      b) Funkcionální přístup: Tento přístup by mohl být efektivnější v některých případech,
 *         ale může být méně intuitivní pro vývojáře zvyklé na objektově orientované programování.
 * 
 * 2. **Princip a možnosti genericity:**
 *    - Genericita umožňuje vytvářet obecné třídy a metody, které mohou pracovat s různými datovými typy,
 *      aniž by bylo nutné psát duplicitní kód.
 *    - V programu Garaz by mohla být genericita využita například pro správu různých typů vozidel
 *      (osobní auta, nákladní auta, motocykly) v rámci jedné kolekce.
 *    - Výhody genericity zahrnují zvýšení znovupoužitelnosti kódu a snížení pravděpodobnosti chyb
 *      způsobených nesprávným typem dat.
 * 
 * 3. **Možnosti rozhraní a výhody jejich používání:**
 *    - Rozhraní definují smlouvu, kterou musí implementující třídy dodržovat, což zvyšuje flexibilitu
 *      a umožňuje polymorfismus.
 *    - V programu Garaz by rozhraní mohlo být použito například pro definici společného chování
 *      všech typů vozidel (např. metoda `start()` nebo `stop()`).
 *    - Výhody zahrnují snadnější rozšiřitelnost systému a možnost měnit implementace bez ovlivnění
 *      zbytku kódu.
 * 
 * 4. **Možnosti a význam vnořených nebo vnitřních a anonymních typů:**
 *    - Vnořené třídy mohou být použity pro logické seskupení tříd, které spolu úzce souvisejí,
 *      což zlepšuje organizaci kódu.
 *    - Vnitřní třídy mají přístup k členům obklopující třídy, což může být užitečné pro implementaci
 *      složitějších funkcionalit.
 *    - Anonymní třídy umožňují rychlé vytvoření jednorázových implementací rozhraní nebo abstraktních tříd.
 *    - V programu Garaz by anonymní třídy mohly být použity například pro implementaci jednorázových
 *      obslužných rutin nebo callbacků.
 * 
 * Tento program je navržen s ohledem na rozšiřitelnost, čitelnost a efektivitu, přičemž využívá
 * moderní principy objektově orientovaného programování.
 */