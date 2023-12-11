package com.damisola.wtfnoteapp.components

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Preview
@Composable
fun NoteItem(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Row (modifier =Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Title of the note",
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "10:15pm",
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.End
                )
            }
                Text(text = "Content of the note will be here lorem ipausm jsks")

        }
    }
}