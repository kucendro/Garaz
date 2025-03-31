# Dokumentace k programu Garaz:

*Toto je dokumentace k programu Garaz, což je appka na správu garáže. Používá Java Swing (JOptionPane), takže to má takový old-school vibe, ale pořád je to user-friendly.*

---

### 1. **Jak to vlastně funguje a proč je to cool**

Program Garaz jede na objektově orientovaném přístupu (OOP), což znamená, že všechno je rozdělené do tříd, jako třeba auta nebo seznam aut. Prostě vše pěkně na svém místě. Tady jsou hlavní výhody:

- **Modularita a čitelnost:** *Kód je rozdělený tak, že to pochopí i tvoje babička (možná).*
- **Znovupoužitelnost:** *Jednou napíšeš a můžeš používat pořád dokola. Prostě win-win.*

Porovnával jsem tři různé způsoby, jak ukládat data, a tady je verdikt:

#### a) *Uspořádaný seznam (ArrayList)*
Použití `ArrayList` je jednoduché a intuitivní. Jedná se o dynamické pole, které umožňuje přidávat a odebírat prvky. V tomto případě je seznam udržován seřazený podle SPZ (např. při každém vložení nového prvku se zařadí na správné místo).

- **Výhody**:
  - Snadná implementace.
  - Přehlednost a jednoduchost kódu.
  - Vhodné pro malé množství dat, kde není výkon kritický.

- **Nevýhody**:
  - Operace vkládání a mazání mají časovou složitost O(n), protože je nutné prvky posouvat.
  - Vyhledávání je rychlejší než u neseřazeného seznamu (O(log n) při binárním vyhledávání), ale stále pomalejší než u jiných struktur, jako je hashovací tabulka.

Tato volba je ideální, pokud pracujete s malým datasetem, kde není potřeba optimalizovat výkon na úkor složitosti implementace.

---

#### b) *Binární vyhledávací strom (BST)*
Binární vyhledávací strom je datová struktura, která umožňuje rychlé vyhledávání, vkládání a mazání prvků. Každý uzel má maximálně dva potomky (levý a pravý), přičemž levý potomek obsahuje menší hodnoty a pravý větší.

- **Výhody**:
  - Rychlé vyhledávání, vkládání a mazání s průměrnou časovou složitostí O(log n).
  - Data jsou automaticky udržována seřazená, což usnadňuje operace jako iterace v pořadí.

- **Nevýhody**:
  - Implementace je složitější než u `ArrayList`.
  - V nejhorším případě (např. pokud je strom nevyvážený) může časová složitost degradovat na O(n).
  - Pro malé množství dat může být režie spojená s BST zbytečná.

BST je vhodný, pokud očekáváte časté vyhledávání a potřebujete udržovat data seřazená, ale zároveň pracujete s větším množstvím dat.

---

#### c) *Hashovací tabulka*
Hashovací tabulka je datová struktura, která mapuje klíče na hodnoty pomocí hashovací funkce. Je extrémně rychlá pro operace jako vkládání, mazání a vyhledávání.

- **Výhody**:
  - Časová složitost O(1) pro většinu operací (v ideálním případě).
  - Velmi efektivní pro velké množství dat, kde je klíčové rychlé vyhledávání.

- **Nevýhody**:
  - Data nejsou seřazená, což znamená, že operace jako iterace v pořadí nebo filtrování podle určitého kritéria jsou obtížné nebo neefektivní.
  - Implementace může být složitější, zejména pokud je třeba řešit kolize (např. pomocí řetězení nebo otevřeného adresování).

Hashovací tabulka je skvělá volba, pokud je prioritou rychlost vyhledávání a nepotřebujete data v určitém pořadí.

---

### Shrnutí
- **ArrayList** je jednoduchý a vhodný pro malé množství dat, kde není výkon kritický.
- **BST** je rychlejší a udržuje data seřazená, ale je složitější na implementaci a může být zbytečný pro malé dataset.
- **Hashovací tabulka** je extrémně rychlá, ale neumožňuje snadné třídění nebo filtrování.

Pro malý dataset, jako je seznam aut v garáži, je `ArrayList` rozumnou volbou, protože jeho jednoduchost převažuje nad potřebou optimalizace výkonu. Pokud by se dataset zvětšil nebo by bylo potřeba časté vyhledávání, mohlo by být vhodné zvážit BST nebo hashovací tabulku.

---

### 2. **Genericita – co to je a proč je to boží**

Genericita je něco jako kouzlo, díky kterému můžeš psát univerzální kód. V našem programu by se to hodilo třeba na správu různých typů vozidel (auta, motorky, tanky, co chceš).

#### Proč je genericita top:
- **Znovupoužitelnost:** Jeden kód vládne všem.
- **Typová bezpečnost:** Kompilátor tě nenechá udělat blbost.
- **Čitelnost:** Kód je čistý.

#### Příklad:
```java
class Seznam<T> {
    private ArrayList<T> seznam = new ArrayList<>();

    public void pridat(T objekt) {
        seznam.add(objekt);
    }

    public void zobraz() {
        for (T objekt : seznam) {
            System.out.println(objekt);
        }
    }
}
```
Takhle můžeš spravovat cokoliv – auta, náhradní díly, nebo třeba seznam oblíbených memů. 😎

---

### 3. **Rozhraní – co to je a proč by tě to mělo zajímat**

Rozhraní je něco jako "smlouva", kterou musí třídy dodržovat. V našem programu by se to hodilo třeba na definici chování všech typů vozidel.

#### Příklad:
```java
interface VozidloRozhrani {
    void start();
    void stop();
}
```
Každý typ vozidla (auto, motorka, UFO) by pak musel mít metody `start()` a `stop()`. Easy peasy.

#### Proč je to cool:
- **Flexibilita:** Můžeš měnit implementace, jak se ti zlíbí.
- **Rozšiřitelnost:** Přidáš nový typ vozidla bez většího drama.
- **Polymorfismus:** Můžeš pracovat s různými objekty jednotně. Prostě pohoda.

---

### 4. **Vnořené a anonymní třídy – co to je za magii**

#### Vnořené třídy:
To jsou třídy uvnitř jiných tříd. Třeba servisní záznamy auta by mohly být vnořené do třídy `Vozidlo`.

```java
class Vozidlo {
    class ServisniZaznam {
        private String popis;
        private String datum;

        public ServisniZaznam(String popis, String datum) {
            this.popis = popis;
            this.datum = datum;
        }
    }
}
```

#### Anonymní třídy:
To je něco jako "rychlovka" na implementaci rozhraní nebo abstraktních tříd. Třeba na jednorázové porovnání aut podle roku výroby:

```java
Comparator<Vozidlo> comparator = new Comparator<>() {
    @Override
    public int compare(Vozidlo v1, Vozidlo v2) {
        return v1.getRokVyroby().compareTo(v2.getRokVyroby());
    }
};
```

#### Proč to používat:
- **Organizace kódu:** Všechno je pěkně pohromadě.
- **Jednoduchost:** Nemusíš vytvářet extra třídy.

---

**Závěr:**
Program Garaz je jednoduchý, efektivní a přitom dostatečně flexibilní. Používá moderní principy OOP, takže je to nejen funkční, ale i elegantní. A jo, Java Swing je možná retro co no.
