## Dokumentace k programu Garaz:

*Tento program implementuje správu garáže s využitím objektově orientovaného přístupu a moderních principů programování.*

---

### 1. **Rozbor implementace a porovnání efektivity**

Program Garaz je navržen s využitím objektově orientovaného přístupu (OOP), což znamená, že jednotlivé části jsou rozděleny do tříd, které reprezentují reálné objekty, jako jsou vozidla nebo seznam vozidel. Tento přístup přináší několik klíčových výhod:

- **Modularita a čitelnost:** *Kód je rozdělen do logických celků, což usnadňuje jeho pochopení a údržbu.*
- **Znovupoužitelnost:** *Jednotlivé třídy lze snadno znovu použít v jiných projektech nebo rozšířit o nové funkcionality.*

Pro porovnání efektivity byly zváženy další dva přístupy:

#### a) *Procedurální přístup*
Procedurální programování by znamenalo, že veškerá logika programu by byla implementována pomocí funkcí a globálních proměnných. Tento přístup by mohl být méně čitelný, protože by chyběla jasná struktura a oddělení odpovědností. Například správa vozidel by byla realizována pomocí seznamů a funkcí, což by mohlo vést k nejasnostem a vyšší chybovosti při větším rozsahu kódu.

#### b) *Funkcionální přístup*
Funkcionální programování by mohlo být efektivnější v některých případech, například při práci s kolekcemi nebo při paralelním zpracování dat. Nicméně pro vývojáře zvyklé na OOP by tento přístup mohl být méně intuitivní. Navíc by bylo obtížnější modelovat reálné objekty, jako jsou vozidla, protože funkcionální přístup se zaměřuje spíše na transformaci dat než na jejich reprezentaci.

Zvolený objektově orientovaný přístup je tedy ideální volbou pro tento typ aplikace, protože umožňuje snadné modelování reálného světa, čitelnost kódu a jeho rozšiřitelnost.

---

### 2. **Princip a možnosti genericity**

Genericita je klíčovým prvkem moderního programování, který umožňuje vytvářet obecné třídy a metody, jež mohou pracovat s různými datovými typy. V programu Garaz by genericita mohla být využita například pro správu různých typů vozidel (osobní auta, nákladní auta, motocykly) v rámci jedné kolekce.

#### Výhody genericity:
- **Znovupoužitelnost kódu:** Jedna třída nebo metoda může být použita pro různé datové typy, což snižuje množství duplicitního kódu.
- **Typová bezpečnost:** Genericita umožňuje detekovat chyby spojené s nesprávným typem dat již při kompilaci.
- **Čitelnost:** Kód je přehlednější, protože není nutné používat explicitní přetypování.

#### Příklad použití genericity:
V programu Garaz by mohla být třída `SeznamVozidel` implementována jako generická, což by umožnilo spravovat nejen vozidla, ale i jiné typy objektů, například náhradní díly nebo servisní záznamy.

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

---

### 3. **Možnosti rozhraní a výhody jejich používání**

Rozhraní v Javě definují "smlouvu", kterou musí implementující třídy dodržovat. To znamená, že každá třída, která implementuje rozhraní, musí obsahovat všechny jeho metody. Rozhraní jsou klíčová pro dosažení polymorfismu a flexibility v návrhu aplikací.

#### Použití rozhraní v programu Garaz:
V programu Garaz by rozhraní mohlo být použito například pro definici společného chování všech typů vozidel. Rozhraní `VozidloRozhrani` by mohlo obsahovat metody jako `start()` a `stop()`, které by byly implementovány různými typy vozidel.

```java
interface VozidloRozhrani {
    void start();
    void stop();
}
```

#### Výhody rozhraní:
- **Flexibilita:** Umožňuje snadno měnit implementace bez ovlivnění zbytku kódu.
- **Rozšiřitelnost:** Nové typy vozidel lze přidat jednoduše implementací existujícího rozhraní.
- **Polymorfismus:** Umožňuje pracovat s různými typy objektů jednotným způsobem.

#### Rozhraní v Javě:
Java nabízí několik vestavěných rozhraní, která lze využít například pro řazení, průchod nebo filtrování kolekcí:
- **`Comparable`**: Používá se pro definici přirozeného řazení objektů.
- **`Comparator`**: Umožňuje definovat vlastní pravidla pro řazení.
- **`Iterable`**: Umožňuje iterovat přes kolekce pomocí cyklu `for-each`.

---

### 4. **Možnosti a význam vnořených nebo vnitřních a anonymních typů**

#### Vnořené třídy:
Vnořené třídy jsou třídy definované uvnitř jiné třídy. Mohou být použity pro logické seskupení tříd, které spolu úzce souvisejí. Například v programu Garaz by mohla být vnořená třída použita pro reprezentaci servisních záznamů vozidla.

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

#### Vnitřní třídy:
Vnitřní třídy mají přístup k členům obklopující třídy, což může být užitečné pro implementaci složitějších funkcionalit. Například v programu Garaz by vnitřní třída mohla být použita pro správu historie změn vozidla.

#### Anonymní třídy:
Anonymní třídy umožňují rychlé vytvoření jednorázových implementací rozhraní nebo abstraktních tříd. V programu Garaz by mohly být použity například pro implementaci jednorázových obslužných rutin.

```java
Comparator<Vozidlo> comparator = new Comparator<>() {
    @Override
    public int compare(Vozidlo v1, Vozidlo v2) {
        return v1.getRokVyroby().compareTo(v2.getRokVyroby());
    }
};
```

#### Výhody:
- **Organizace kódu:** Vnořené a vnitřní třídy zlepšují organizaci kódu tím, že seskupují související logiku.
- **Jednoduchost:** Anonymní třídy umožňují rychlou implementaci bez nutnosti vytvářet samostatnou třídu.

---

**Závěr:**
Program je navržen s ohledem na čitelnost, rozšiřitelnost a efektivitu. Využívá moderní principy objektově orientovaného programování, jako jsou genericita, rozhraní a vnořené třídy, což z něj činí robustní a flexibilní řešení pro správu vozidel.
