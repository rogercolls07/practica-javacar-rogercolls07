[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/AE97dmt6)
# JavaCar – Sistema de Gestió de Lloguer de Vehicles

> **Pràctica PR02 – Ordinària** | Mòduls: 0485-Programació · 0487-Entorns · 1708-Sostenibilitat

---

## Què és aquest projecte?

**JavaCar** és un sistema de lloguer de vehicles fet en **Java**. Permet gestionar cotxes, motos i furgonetes disponibles per llogar, calcular els preus de cada lloguer i saber quants ingressos s'han generat.

El projecte serveix per practicar la **Programació Orientada a Objectes (POO)**: classes, herència, interfícies, classes abstractes, etc.

Com a programador/a júnior, t'incorpores a un equip on l'arquitectura del projecte ja està definida. La teva feina és implementar les funcionalitats que falten i fer que tots els testos passin.

---

## Com està organitzat el codi?

El projecte té les classes i mòduls següents:

### 1. Interfície `Llogable`
Tots els vehicles han de poder calcular el seu preu de lloguer. Per garantir-ho, implementen aquesta interfície:

```
calcularPreu(dies)
```

### 2. Classe abstracta `Vehicle` (implementa `Llogable`)
És la classe **base** de tots els vehicles. Conté els atributs comuns:

| Atribut              | Descripció                        |
|----------------------|-----------------------------------|
| `matricula`          | Matrícula del vehicle             |
| `marca`              | Marca del vehicle                 |
| `model`              | Model del vehicle                 |
| `preuBase`           | Preu per dia en euros             |
| `motor`              | Objecte `Motor` del vehicle       |
| `rodes`              | Array de `Roda` del vehicle       |
| `etiquetaAmbiental`  | Etiqueta ambiental de la DGT      |

Té un constructor amb tots els atributs i *getters* per a cada un.

### 3. Classes concretes de vehicles

Totes hereten de `Vehicle` i implementen `calcularPreu`:

#### `Cotxe`
```
Cotxe(matricula, marca, model, preuBase, nombrePlaces, motor, rodes)
```
- Atribut extra: `nombrePlaces`

#### `Moto`
```
Moto(matricula, marca, model, preuBase, cilindrada, motor, rodes)
```
- Atribut extra: `cilindrada` (en cc)
- `calcularPreu(dies)` → si `cilindrada > 500`, afegeix **5€** al `preuBase`

#### `Furgoneta`
```
Furgoneta(matricula, marca, model, preuBase, capacitatCarga, motor, rodes)
```
- Atribut extra: `capacitatCarga` (en kg)
- `calcularPreu(dies)` → si `capacitatCarga > 1000`, afegeix **10€** al `preuBase`

### 4. Classes `Motor` i `Roda`

```
Motor(tipus, potencia)
Roda(marca, diametre)
```

### 5. Classe estàtica `GestorLloguers`
Gestiona les operacions sobre llistes de vehicles:

```
calcularIngressosTotals(vehicles, dies)   → retorna el total d'ingressos de tots els vehicles per N dies
filtrarPerPreu(vehicles, preuMax)         → retorna els vehicles que costen igual o menys que el preu màxim
```

---

## Nota de Sostenibilitat 🌱

Tots els vehicles han de tenir una **etiqueta mediambiental** (tal com estableix la normativa de la DGT). Hauràs d'afegir els atributs i mètodes necessaris per:

1. **Guardar** la informació del vehicle rellevant per al càlcul.
2. **Calcular** l'etiqueta correcta al constructor.
3. **Recalcular-la** si les característiques del vehicle canvien.

Consulta el criteri oficial aquí:
🔗 [Distintiu Ambiental de la DGT – Ajuntament de Barcelona](https://ajuntament.barcelona.cat/qualitataire/ca/zona-de-baixes-emissions/el-distintiu-ambiental-de-la-dgt)

---

## Les tres fases del projecte

### Fase 1 – Implementació del codi
Crea i completa totes les classes seguint les especificacions de l'apartat anterior. Assegura't que tots els **testos unitaris** passen.

### Fase 2 – Disseny UML
Dissenya la documentació tècnica del projecte:
- **Diagrama de classes**
- **Diagrama de casos d'ús** (mínim 3 directes + 3 indirectes)
- **Taula de requisits funcionals** (mínim sobre 3 casos d'ús)
- **Diagrames d'activitat** (mínim sobre 3 casos d'ús)

Proposa funcionalitats addicionals creatives: historial de lloguers, descomptes, nous tipus de vehicles, integració amb fitxers, etc.

### Fase 3 – Implementació final i demo
- Revisa i finalitza totes les classes.
- Valida que tots els testos passen.
- Prepara una **demo funcional** que mostri les funcionalitats implementades.

---

## Testos i CI/CD

El projecte inclou **testos unitaris** i validació automàtica mitjançant **GitHub Actions**. Cada cop que fas un `push` a la branca `main`, s'executaran automàticament els testos per garantir el bon funcionament del codi.

---

## Lliurament i avaluació

### Què has d'entregar?
- Totes les classes implementades i l'aplicació funcional.
- Documentació UML completa.
- Una presentació amb la guia d'ús i les funcionalitats del programa.

### Com s'avalua?
| Criteri                                                   |
|-----------------------------------------------------------|
| Implementació correcta i completa del codi                |
| Qualitat i organització del codi                          |
| Testos unitaris superats                                  |
| Implementació coherent del distintiu ambiental (DGT)      |
| Originalitat i millores extres                            |
| Qualitat dels dissenys UML                                |
| Claredat en la demostració                                |
| Extra: aplicació de metodologia SCRUM                     |
| Extra: ús de GitHub Issues per gestionar tasques          |

> ⚠️ **Penalització**: No utilitzar correctament el control de versions de Git/GitHub comporta penalització en la nota.

---

## RAs relacionats

- **0485 – Programació**: RA2, RA4, RA6, RA7
- **0487 – Entorns de desenvolupament**: RA4, RA5, RA6
- **1708 – Sostenibilitat aplicada al sistema productiu**: tots els RAs
