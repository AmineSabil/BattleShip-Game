# Bataille Navale

## Auteur :

- SABIL Mohamed Amine


## Comment générer la documentation ?

Placez vous dans le sous-dossier src :

pour générer la documentation des classes du paquetage battleship et du sous paquetage battleship il suffit de saisir dans le terminal la commande : `javadoc battleship battleship.util -d ../docs/BATTLESHIP`

==> les fichiers générés de la documentation du paquetage battleship se trouve dans le sous répértoire BATTLESHIP du répertoire docs.

pour générer la documentation des classes du paquetage io il suffit de saisir  dans le terminal la commande : `javadoc io -d ../docs/IO`

==> les fichiers générés de la documentation du paquetage io se trouve dans le sous répértoire IO du répertoire docs.

## Comment compiler les classes du projet ?
Placez vous dans le sous-dossier src :

pour compiler toutes les classes du paquetage battleship il suffit de saisir  dans le terminal : `javac battleship/BattleShipMain.java -d ../classes`

===> ainsi toutes les classes contenues dans le paquetage battleship et le sous paquetage battleship.util seront compilés car ils sont utilisés dans la classe BattleShipMain

pour compiler LA CLASSE Input du paquetage io il suffit de saisir dans le terminal : `javac io/Input.java -d ../classes`

===> ainsi la classe Input contenu dans le paquetage io sera compilé

## Comment compiler puis exécuter les tests ?
placez vous dans la branche principale ..

* pour compiler les tests:
pour le fichier CellTest.java  éxécutez la commande: `javac -classpath test-1.7.jar test/CellTest.java`

puis pour le fichier PositionTest.java éxécutez la commande: `javac -classpath test-1.7.jar test/PositionTest.java`

puis pour le fichier SeaTest.java éxécutez la commande: `javac -classpath test-1.7.jar test/SeaTest.java`

puis pour le fichier ShipTest.java éxécutez la commande: `javac -classpath test-1.7.jar test/ShipTest.java`


* pour les éxécuter il suffit de saisir:
pour CellTest éxécutez la commande: `java -jar test-1.7.jar CellTest`
et
pour PositionTest  éxécutez la commande: ` java -jar test-1.7.jar PositionTest`
et
pour SeaTest  éxécutez la commande:  `java -jar test-1.7.jar SeaTest`
et
pour ShipTest  éxécutez la commande:  `java -jar test-1.7.jar ShipTest`

## Comment créer le jar exécutable ?

Placez vous dans le sous-dossier classes :

- pour créer le jar il suffit d'executer : `jar cvf ../battleship.jar battleship io`
- puis executez la commande : `jar cvfm ../battleship.jar ../manifest-ex battleship io`
- pour ajouter le dossier docs et test dans l'archive il suffit de se placer dans tp5 (avec la commande cd ..)
puis executez la commande : `jar cvfm battleship.jar manifest-ex docs test -C classes battleship io`

et le jar est donc complet pour l'executer il suffit de se placer dans tp5 toujours et  d'executer la commande : `java -jar battleship.jar`

## Comment tester l'exécution du programme ?

pour tester l'execution du programme il suffit d'executer la CLASSE qui contient le main :
puis placez vous dans la branche principale du projet :

- pour executez la commande:  `java -classpath classes battleship.BattleShipMain`

ou

- executez la commande:  `java -jar battleship.jar`
