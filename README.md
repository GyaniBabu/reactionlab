# reactionlab
This Java repository models chemical stoichiometry for reactions of the form aA + bB -> cC + dD. It automatically computes reaction extent, identifies limiting reagents, calculates final reactant and product quantities, and includes a main method demonstrating five real-world chemical processes like thermite and Sabatier.
Here is a detailed description of the codebase based on the provided Java class.

---

### ## Overview

This repository contains a **Chemical Stoichiometry and Limiting Reagent Calculator** implemented in Java. The program models standard chemical reactions of the general form:

$$\text{aA} + \text{bB} \rightarrow \text{cC} + \text{dD}$$

It computes the extent of a reaction, identifies limiting reagents, determines the final quantities of reactants and products, and prints formatted text reports.

---

### ## Key Features & Methods

* **`extent()`**: Automatically determines the limiting reagent and calculates the maximum possible extent of the reaction using the ratio of initial amounts to stoichiometric coefficients:

$$\text{extent} = \min\left(\frac{\text{initial\_a}}{a}, \frac{\text{initial\_b}}{b}\right)$$


* **`react()`**: Computes the final quantities of reactants consumed and products formed based on the calculated reaction extent.
* **`finalAmount(String species)`**: Allows querying the final mole amount of any specific reactant or product by name.
* **`report()`**: Outputs a clean, formatted console summary showing the balanced chemical equation, initial input amounts, and final quantities left or produced.

---

### ## Included Demonstration Examples

The `main` method showcases five distinct chemical reactions:

1. **Operation Iron Rain (Thermite Reaction):**
$\text{Fe}_2\text{O}_3 + 2\text{Al} \rightarrow 2\text{Fe} + \text{Al}_2\text{O}_3$
2. **Project Methane (Sabatier Reaction):**
$\text{CO}_2 + 4\text{H}_2 \rightarrow \text{CH}_4 + 2\text{H}_2\text{O}$
3. **Operation Purple Fade (Iodine-Thiosulfate Titration):**
$2\text{Na}_2\text{S}_2\text{O}_3 + \text{I}_2 \rightarrow \text{Na}_2\text{S}_4\text{O}_6 + 2\text{NaI}$
4. **Operation Fool's Gold (Pyrite Roasting):**
$4\text{FeS}_2 + 11\text{O}_2 \rightarrow 2\text{Fe}_2\text{O}_3 + 8\text{SO}_2$
5. **Operation Copper Resurrection (Copper Oxide Reduction):**
$\text{CuO} + \text{H}_2 \rightarrow \text{Cu} + \text{H}_2\text{O}$
