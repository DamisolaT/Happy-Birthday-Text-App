package com.damisola.wtfnoteapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.damisola.wtfnoteapp.models.Note
import com.damisola.wtfnoteapp.screens.AddNoteScreen
import com.damisola.wtfnoteapp.screens.NoteDetailsScreen
import com.damisola.wtfnoteapp.screens.NoteListScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.NoteListRoute
    ){
        composable(Routes.NoteListRoute){
            NoteListScreen(navController)
        }
        composable(Routes.AddNoteRoute){
            AddNoteScreen(navController)
        }
        composable("note-details/{noteId}"){
            NoteDetailsScreen(navController = navController,
                noteId = it.arguments!!.getString("noteId")!!
            )
        }
    }
}
 object Routes{
     val NoteListRoute = "note-list"
     val AddNoteRoute = "add-note"

     fun NoteDetails(noteId: String): String{
         return "note-details/$noteId"
     }
 }