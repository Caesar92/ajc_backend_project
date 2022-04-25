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
    "password" : "cesargonnot",
}
```
=> Récupération du token dans la réponse de l'url (à mettre dans la partie "Authorization -> Bearer Token)
