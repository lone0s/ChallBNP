On a un Rover
Le Rover se déplace sur une Grid en 2D (Rectangulaire ? <-- non, simplifié en espace 2D)

Il recoit des "messages" aka des instructions : 
- L (rotation 90 degres vers la gauche)
- R (rotation 90 degres vers la droite)
- M (avance suivant son orientation)

==> Avoir des objets pour représenter les messages 
==> Que la logique de déplacement est gérée par le Rover directement 
==> Simple encapsulation de la notion de "message" avec controle du déplacement relégué au rover 

Factory pour le fun ou overkill pour trois instructions ? 
Go pour factory, on veut séparer les responsabilités 

Deja le seul a connaitre sa position et son orientation c'est le rover 
==> Rover { private Position ; private Orientation}
Il doit pouvoir recevoir des messages 
==> public receiveMessage (Message message) { updatePositionOrLocation(message) } 
==> private updatePositionOrLocation(Message message)
Dans l'idée, en réalité si on va sur un factory, va falloir gérer chaque "execute" donc trois fonctions différentes

Ensuite pour la mise à jour des positions par rapport aux orientations, j'ai pas envie de faire des switch case dans tous les sens
Soit je fais du polymorphisme pur, avec des classes dans tous les sens, soit enum polymorphique directement

On a que quatre orientations donc might as well tout condenser

Comment je suis censé savoir si c'est une bonne idée d'overengineer la solution ou non...

Sinon on traite un rover à la fois, ca implique en recréer a chaque fois !!!! Pas de reinit

Edge case : un rover se retrouve a la même position que celle du précédent, on fait quoi ? <-- On s'en fiche