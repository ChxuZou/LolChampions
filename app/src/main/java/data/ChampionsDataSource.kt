package data

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import model.Ability
import model.Champion

class ChampionsDataSource {

    private val COLECCION_CHAMPIONS = "Champion"
    private val CAMPO_NAME = "name"
    private val CAMPO_DESCRIPTION = "description"
    private val CAMPO_IMAGEN = "image"
    private val CAMPO_ABILITIES = "abilities"

    private val db = FirebaseFirestore.getInstance()
    private val champions = db.collection(COLECCION_CHAMPIONS)

    fun getChampions(setLista: (List<Champion>) -> Unit) {

        val listaChampions = mutableListOf<Champion>()

        champions.get().addOnSuccessListener { champions ->

            for (champion in champions) {

                val name = champion.getString(CAMPO_NAME) ?: ""
                val description = champion.getString(CAMPO_DESCRIPTION) ?: ""
                val image = champion.getString(CAMPO_IMAGEN) ?: ""

                val abilitityDocuments = champion[CAMPO_ABILITIES] as List<DocumentReference>
                val listaAbilities = getAbilities(abilitityDocuments)

                val championAux = Champion(
                    nameRes = name,
                    descriptionRes = description,
                    imageRes = image,
                    abilities = listaAbilities
                )
                listaChampions.add(championAux)
            }
            setLista(listaChampions)
        }
    }

    private fun getAbilities(abilityDocuments: List<DocumentReference>): MutableList<Ability> {
        val listaAbilities = mutableListOf<Ability>()

        for (abilityDocument in abilityDocuments) {
            abilityDocument.get().addOnSuccessListener { ability ->
                val imagen = ability.getString(CAMPO_IMAGEN) ?: ""
                val descripcion = ability.getString(CAMPO_DESCRIPTION) ?: ""

                val habilidad = Ability(imageRes = imagen, descriptionRes = descripcion)

                listaAbilities.add(habilidad)
            }
        }
        return listaAbilities
    }

}
