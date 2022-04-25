# ajc_backend_project

## Exemple de données à saisir pour la connexion
URL SIGNUP : http://localhost:8080/api/auth/signup
```json
{
    "email": "cesar@gonnot.com",
    "password" : "cesargonnot",
    "prenom": "Cesar",
    "nom" : "Gonnot",
    "adresse" : "17 allées léon gambetta",
    "code_postal" : "92110",
    "ville": "Clichy",
    "pays": "France",
    "date_de_naissance": "17/03/1997",
    "listRole" : []
}
```

URL SIGNIN : http://localhost:8080/api/auth/signin
```json
{
    "email": "cesar@gonnot.com",
    "password" : "cesargonnot"
}
```
=> Récupération du token dans la réponse de l'url (à mettre dans la partie "Authorization -> Bearer Token)


## Les routes
### Vetements
````
Get all vetements : get:api/vetements
Get vetement by id : get:api/vetements/:id
Update vetement : put:api/vetements
Post vetement : post:api/vetements
Delete vetement : delete:api/vetements
Add avis on vetements : put:api/vetements/addAvis/:id
Filter : get:api/vetements/filtre?taille=?&min=?&max=?&sexe=?
=> taille = [S, M, L] et sexe = [Homme, Femme, Unisexe]
````

### Users
````
Get all users : get:api/users
Get vetement by id : get:api/users/:id
Update vetement : put:api/users
Post vetement : post:api/users
Delete vetement : delete:api/users
Ajouter un vetement au panier : put:api/users/addVetement?userId=?&vetementId=?
Supprimer un vetement du panier : put:api/users/removeVetement?userId=?&vetementId=?
Vider le panier : put:api/users/clearVetement?userId=?
Payer le panier : put:api/users/paidVetement?userId=?
-------------------------------------------------------------------------
Authentification : post:api/auth/signin
Création de compte : post:api/auth/signup
````

### Roles
````
Get all users : get:api/roles
Get vetement by id : get:api/roles/:id
Update vetement : put:api/roles
Post vetement : post:api/roles
Delete vetement : delete:api/roles
````

### Stocks
````
Get all stocks : get:api/stocks
Get stock by id : get:api/stocks/:id
Update stock : put:api/stocks
Post stock : post:api/stocks
Delete stock : delete:api/stocks/:id
Diminuer le stock de 1 pour un vetement : delete:api/stocks/stock/:id
Agmenter le stock de 1 : pris en compte dans les urls de users
````

### Categories
````
Get all stocks : get:api/categories
Get stock by id : get:api/categories/:id
Update stock : put:api/categories
Post stock : post:api/categories
Delete stock : delete:api/categories/:id
````

### Avis
````
Get all stocks : get:api/avis
Get stock by id : get:api/avis/:id
Update stock : put:api/avis
Post stock : post:api/avis
Delete stock : delete:api/avis/:id
````