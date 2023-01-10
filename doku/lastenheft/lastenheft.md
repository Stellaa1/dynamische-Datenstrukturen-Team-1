## Lastenheft Team 1

**Entwicklung eines Wer wird Milionär Spieles**

| Stand        | 06.11.2022                                                  |
|--------------|-------------------------------------------------------------|
| Auftraggeber | Hermann-Emanuel-Berufskolleg Informatik LK Abschlussprojekt |

# Inhaltsverzeichnis
1. [Einleitung](#1-einleitung)
2. [Soll-Konzept](#2-soll-konzept)
3. [Anforderungen](#3-anforderungen)
4. [Entwürfe](#4-entwrfe)


## 1 Einleitung
*Eine kurze Einstimmung zum Projekthintergrund*

Im Informatik Leistungskurs entwickeln die Lernenden ein Projekt.
Im Rahmen des Softwareentwicklungsprozesses sind typische Dokumente wie das Pflichtenheft zu erstellen.
Dynamische Datenstrukturen wie List, Stack und Queue sollen dem Softwareentwicklungsprozess
mit den entsprechenden Dokumenten aufgezeigt werden. Dazu wird ein Graphical User Interface verwendet.

## 2 Soll-Konzept

### 2.1 Anwendungsbreiche
*Beschreibung der vorgesehenen Anwendungsfälle des zu schaffenden Systems.*
Das Spiel kann man in mehreren Variationen spielen. Entweder in Einzelmodus oder Multiplayer. Für Einzelmodus
kann man zwischen Normal oder Reverse entscheiden. Mit Normal ist das normale Spiel gemeint, wo  man 10/15/20 Fragen hat,
die immer schwerer werden. Dazu kriegt man natürlich 4 Antwortmöglichkeiten, wobei 3 davon falsch sind. Der Reverse Modus
funktioniert ähnlich, der einzige Unterschied ist, dass man mit der schwierigsten Frage anfängt und später immer leichtere
Fragen kriegt. In Multiplayer kann man auch zwischen zwei Spielmodi entscheiden. Entweder spielt man mit Freunden,
dem Normalmodus oder Question Maker. In dem Normalmodus kämpft man um den besten Highscore/Platz und um die meisten Punkten.
Bei Question Maker kann jeder Spieler 10 Fragen alleine erstellen und dann seinen Freund zur beantworten geben.

Wir wollen, dass die Spieler in jedem Modus sin wissen testen und erweitern.
Außerdem sollen die Spieler dabei Spaß haben und den besten Platz in der Top 10 erreichen.

### 2.2 Systemidee
*Welche Idee wird mit dem System umgesetzt?*

Ein "Wer wird Millionär" Spiel, das mit GUI dargestellt wird.

Man startet das Spiel in dem Hauptmenu, wo man zu erst sein Spieler Account erstellt kann. Danach kann man zwischen
Spielen, Multiplayer, Top 10, Einstellungen, Achievements und Schließen auswählen kann.

Spielen:

Der Spieler kann zwischen Normalmodus und Reverse entscheiden.

Normalmodus:

In dem normalen Modus werden dem Spieler Fragen gestellt und die dazugehörige Antworten gezeigt. Der Spieler kann
die seiner Meinung nach richtige Antwort anklicken, oder wenn er nicht weiter weiß ein von dem Joker, die oben
recht angezeigt werden nutzen. Wenn er die Frage richtig beantwortet, kommt er weiter und die nächte Frage wird ihm
angezeigt. Bei Falscher Antwort, kann der Spieler noch das Joker revive nutzen, sonst verliert er das Spiel. Am Ende des Spieles
werden dem Spieler die Punkte und der Platz in Top 10 angezeigt. Der Spieler kann auch zurück in das Menu gehen und z.B. das
Spiel neustarten.
Der Normalmodus wird anhand einer Liste erstellt.

Reverse:

Der Reverse modus funktioniert genau wie der Normalmodus. Der einzige Unterschied ist, dass man erst mit den schwierigsten
Fragen anfängt, d.h., dass man z.B. mit Frage 15 anfängt und später mit Frage 1 aufhört. Die Fragen werden solange gestellt,
bis der Spieler gewinnt bzw. verliert. Am Ende des Spieles kann defr Spieler seine Punkte und dem Platz in Top 10
sehen. Danach kann er wieder in das Menu zurück gehen.
Der Reverse Modus wird anhand einer Queue erstellt.

Multiplayer:

In dem Multiplayer kann man auch zwischen zwei Modi entscheiden. Dort steht Normal und Question Maker zur Auswahl.

Normal Multiplayer:

Die Spieler können ihren Namen eingeben und ein Profilbild aussuchen. Wenn beide Spieler fertig sind, können die
auf weiter klicken. Der erste Spieler kriegt eine Frage, wenn er die Frage beantwortet, egal ob richtig oder
falsch, soll er den Surface an den nächsten Spieler weitergeben. Die Spieler spielen so lange, bis jeder seine Fragen
beantwortet. Am Ende werden die Punkte gezählt und der Highscore angezeigt. Der Spieler mit meisten Punkten hat gewonnen.
Der Multiplayer wird anhand einer Liste erstellt.

Question Maker:

Die Spieler können hier auch ihren Namen eingeben und ein Profilbild aussuchen. Der Modus funktioniert hier aber ganz anders.
Der erste Spieler erstellt 10 Fragen und dazugehörigen Antworten. danach wird der Surface dem anderen Spieler gegeben und
er beantwortet die Fragen. Auch wenn er eine Frage falsch beantwortet, wird die nächste angezeigt. Wenn er mit allen Fragen
durch ist, kann er die nächsten 10 erstellen und den ersten Spieler zur beantworten geben. Am Ende werden die Punkte von beiden
Spielern miteinander verglichen und der Spieler mit größerer Punktzahl gewinnt.
Der Question Maker wird anhand einem Stack erstellt.

Top 10:

Wenn man auf Top 10 draufgeht, werden die 10 besten Spieler mit dessen Platz, Spielername, Profilbild und Punkten gezeigt.
Die Spieler haben immer die möglichkeit, sich den Top 10 anzugucken, damit die wissen wer auf dem ersten Platz ist und
wie viele Punkte man kriegen muss, um ihm zu besigen.

Einstellungen:

In den Einstellungen kann man zwischen Fragenanzahl, Cheats und Eklärung auswählen.
Bei Fragenanzahl kann man sich aussuchen, wie viele Fragen man beantworten will. Zur Auswahl stehen 10, 15 und 20 Fragen.
Bei Cheats kann man auswählen, welche Cheats angemacht werden. Wenn man die Cheats bei Spielen nutzt, kommt man nicht in die Top 10 rein.
In Einstellungen kann man sich auch die Erklärungen von Spielmodus, Joker, Cheats und Top 10 angucken. Die werden in kurzen Texten beschrieben
und mit Bildern erklärt.

Achievements:

Während dem ganzen Spiel kann man Achievements sammeln, die auf dem Spieler Account gespeischert werden.
Zur Achievements gehörn:

| **Achivements**                  | **Beschreibung**                                     |
|----------------------------------|------------------------------------------------------|
| Du hast einen langen Weg vor dir | Du hast 5 Fragen hintereinander richtig beantwortet  |
| Kein Defizit                     | Du hast 10 Fragen hintereinander richtig beantwortet |
| Genie                            | Du hast 15 Fragen hintereinander richtig beantwortet |
| Ein Stein                        | Du hast 20 Fragen hintereinander richtig beantwortet |
| Jonas                            | Du hast die erste Frage falsch beantwortet           |
| Muss Mutti wieder helfen?        | Du hast Telefonjoker benutzt                         |
| Siri wirf ne Münze               | Du hast 50/50 Joker benutzt                          |
| Du vertraust den?                | Du hast Publikumsjoker genutzt                       |
| Joker-Master (Mafia Tenbrock)    | Du hast alle Joker genutzt                           |
| Hacker                           | Du hast Cheats genutzt                               |
| Indischer Kundensupport          | Du hast ALLE Cheats genutzt                          |
| Millionär                        | Du hast zum ersten Mal gewonnen                      |
| Milliardär                       | Du hast alle Spielmodi gewonnen                      |

Schlißen:

Das Spiel wird geschlossen. Der Spiler wird aber nochmal gefragt, ob er das Spiel wirklich schlißen will.


### 2.3 Ziele
*Welche konkreten Ziele sollen erreicht werden? (Aufteilung der Idee in Teilziele)*

Unser Spiel soll das Wissen des Spielers testen, aber auch erweitern. Dabei sollen die Spieler Spaß haben und in Endergebniss
so viel Punkte und Achievements wie möglich sammeln.


### 2.4 Zielgruppe
*Benennung der Anforderungsbeitragenden mit Bezug zu deren Anforderungen*

us dem Ziel, den Softwareentwicklungsprozess zu veranschaulichen und andererseits ein einfaches Hello-world-Programm zu entwickeln, lassen sich folgende Beteiligte den grob erfassten Anforderungen zuordnen:

| **Anforderungsbeitragende** | **Anforderung**                                                                                                                                                                                                                                                                                                                                                                                                      |
|-----------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Lernende                    | Die Lernenden sollen ihre Programmierfähigkeiten verbessern und vertiefen. Dabei sollen die lernen, wie man mit GUI arbeitet. In dem Programm sollen auch dynamische Datenstrukturen verwendet werden, die die Lernenden durch das Programm besser kennenlernen und anwende üben. Durch die Gruppenarbeit werden noch zusätzlich solche Fähigkeiten wie gemeinsam Probleme lösen und in Gruppen arbeiten verbessert. |
| Nutzer                      | Die Nutzer sollen Spaß am spielen haben. Wir wollen, dass die sein Wissen testen und erweitern. Außerdem können die einander herausfordern in unseren Multiplayer Modus, aber auch ihre Krativität nutzen, um die Fragen bei Question Maker zur erstellen. Bei spielen können die Nutzer auch Achievements sammel, die auf dessen Accounts gespeichert werden.                                                       |
| Lehrkräfte                  | Der Leher soll die Akzeptanzkriterien uberprüfen und die Lernenden bei Problemen helfen. Die Gruppenarbeit wird durch den Lehere unterstützt.                                                                                                                                                                                                                                                                        |

## 3 Anforderungen

### 3.1 Funktionale Anforderungen
*Hier sind die Anforderungen in einer einheitlichen
und übersichtlichen Form darzustellen.*

*Als Template eignet sich z. B. eine Tabelle.
Eine Gruppierung nach Prozessen, Nutzerrollen
oder fachlichen Bereichen und das Vergeben
eines Identifikators, sowie Verweise auf verwandte
Anforderungen ist ratsam*

Es gibt nur zwei Anforderungen: die Hauptfunktion und eine Hilfefunktion. Der am Betriebssystem angemeldete Nutzer führt das Programm in der Konsole aus. Der Aufruf erfolgt mittels Java-Interpreter.

| Kürzel | Funktionsname       | Funktionsbeschreibung                                                                                                                           |
|--------|---------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| F1     | start game          | Das Spiel wird gestartet                                                                                                                        |
| F2     | use revive          | Nachdem man das Spielt verliert, kann man den Joker Revive nutzen, um weiterspielen zu können.                                                  |
| F3     | use fifty percent   | Zwei von den falschen Fragen werden zufällig ausgewählt und ausgeschaltet                                                                       |
| F4     | use telephone       | Ein Audiospur wird abgespielt, die die richtige Antwort wied  gesagt (A/B/C/D)                                                                  |                                                                            
| F5     | use audience        | Ein Diagramm mit vier Balken wird angezeigt. Je schwerer die Frage ist, desto großer die Wahrscheinlichkeit, dass das Publikum falsch antwortet |
| F6     | ask question        | Die Fragen werden schwere je weiter man kommt. der int Schwierigkeit zählt die gestellten Fragen und passt dem Schwierigkeitsgrad an.           |
| F7     | get question        | Die Fragen werden schwerer je weiter man kommt, so wird dann von Array eine Frage ausgewählt (anhand des int Schwierigkeit)                     |
| F8     | main                | Führt das Programm aus.                                                                                                                         |
| F9     | create player       | Der Spieler kann sein Profil erstellen.                                                                                                         |
| F10    | show top ten        | Top 10 Spieler werden angezeigt (Platz, Name, Profilbild, Punkten)                                                                              |
| F11    | options             | Man kann die Einstellungen ändern.                                                                                                              |
| F12    | choose player       | Man kann dem Spieler auswählen.                                                                                                                 |
| F13    | multiplayer         | Man kann mit Freunden spielen.                                                                                                                  |
| F14    | singelplayer        | Man spielt alleine.                                                                                                                             |
| F15    | question maker      | Man spielt mit Freunden und erstellt die Fragen/Antworten alleine.                                                                              |
| F16    | reverse             | Man fängt mit der schwersten Frage an und kriegt die leichteste am Ende                                                                         |
| F17    | conditions          |                                                                                                                                                 |

### 3.2 Nicht-funktionale Anforderungen

| Kürzel | Funktionsname                    | Funktionsbeschreibung                                                                      |
|--------|----------------------------------|--------------------------------------------------------------------------------------------|
| NF1    | Vollbild                         | Man kann das Programm in Vollbild starten                                                  |                                             
| NF2    | Top 10                           | Top 10 Spieler werden angezeigt                                                            |
| NF3    | Joker Animation                  | Symbol kommt auf                                                                           |
| NF4    | Telefon Joker                    | die Frage wird beantwortet                                                                 |
| NF5    | Publikum Joker                   | Diagramm mit vier Balken, die sich bewegen und nach 4 Sekunden die richtige Antwort zeigen |
| NF6    | 50/50 Joker                      | 2 Felder werden ausgeblendet                                                               |                                                  
| NF7    | Revive Joker                     | Symbol kommt auf --> nächste Frage                                                         |
| NF8    | Du hast einen langen Weg vor dir | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF9    | Kein Defizit                     | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF10   | Genie                            | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF11   | Ein Stein                        | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF12   | Jonas                            | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF13   | Muss Mutti wieder helfen?        | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF14   | Siri wirf ne Münze               | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF15   | Du vertraust den?                | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF16   | Joker-Master (Mafia Tenbrock)    | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF17   | Hacker                           | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF18   | Indischer Kundensupport          | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF19   | Millionär                        | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
| NF20   | Milliardär                       | Symbol und Erklärung wofür man dem Achivement gekriegt hat kommen auf                      |
|

## 4 Entwürfe

### 4.1 Klassendiagramm
*Bevor Sie Beginnen zu implementieren ist hier ein Klassendiagramm anzugeben.*

![Klassendiagramm](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/HEBK-BGM/dynamische-Datenstrukturen-Team-1/master/doku/lastenheft/Diagramme/Klassendiagramm.puml)

### 4.2 Objektdiagramm
*Auf Basis Ihres Klassendiagramms ist hier ein Objektdiagramm anzugeben.*

![Objektdiagramm](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/HEBK-BGM/dynamische-Datenstrukturen-Team-1/master/doku/lastenheft/Diagramme/Objektdiagramm.puml)

### 4.3 Sequenzdiagramm
*Hier wird ein Sequenzdiagramm zu einer Funktion aus 3.1 dargestellt.*

![Sequenzdiagramm](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/HEBK-BGM/dynamische-Datenstrukturen-Team-1/master/doku/lastenheft/Diagramme/Sequenzdiagramm.puml)