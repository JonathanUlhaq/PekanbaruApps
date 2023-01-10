package com.belajar.pekanbaruapps.widgets.pendidikan

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.belajar.pekanbaruapps.widgets.restaurantscreen.FilterItemRestaurant


@Composable
fun PendidikanFilter(
    selected: MutableState<String>,
    search: MutableState<String>
) {
  Column {
      //                    First Row
      Row(
          verticalAlignment = Alignment.CenterVertically
      ) {

          FilterItemRestaurant(
              name = "Semua",
              onClick = {
                  selected.value = "Semua"
                  search.value = ""
              },
              color = when (selected.value) {
                  "Semua" -> MaterialTheme.colors.onSurface
                  else -> MaterialTheme.colors.secondary
              },
              colorSurface = when (selected.value) {
                  "Semua" -> MaterialTheme.colors.primaryVariant
                  else -> MaterialTheme.colors.onSecondary
              }
          )
          Spacer(modifier = Modifier.width(6.dp))

          FilterItemRestaurant(
              name = "Negeri",
              onClick = {
                  selected.value = "Negeri"
                  search.value = "Negeri"
              },
              color = when (selected.value) {
                  "Negeri" -> MaterialTheme.colors.onSurface
                  else -> MaterialTheme.colors.secondary
              },
              colorSurface = when (selected.value) {
                  "Negeri" -> MaterialTheme.colors.primaryVariant
                  else -> MaterialTheme.colors.onSecondary
              }
          )
          Spacer(modifier = Modifier.width(6.dp))

          FilterItemRestaurant(
              name = "Swasta",
              onClick = {
                  selected.value = "Swasta"
                  search.value = "Swasta"
              },
              color = when (selected.value) {
                  "Swasta" -> MaterialTheme.colors.onSurface
                  else -> MaterialTheme.colors.secondary
              },
              colorSurface = when (selected.value) {
                  "Swasta" -> MaterialTheme.colors.primaryVariant
                  else -> MaterialTheme.colors.onSecondary
              }
          )
          Spacer(modifier = Modifier.width(6.dp))

      }
      Spacer(modifier = Modifier.height(12.dp))
      Text(
          text = "Akreditasi Sekolah",
          style = MaterialTheme.typography.h2,
          color = MaterialTheme.colors.surface
      )
      Spacer(modifier = Modifier.height(16.dp))

//      Second Row
      Row(
          verticalAlignment = Alignment.CenterVertically
      ) {

          FilterItemRestaurant(
              name = "Semua",
              onClick = {
                  selected.value = "Semua"
                  search.value = ""
              },
              color = when (selected.value) {
                  "Semua" -> MaterialTheme.colors.onSurface
                  else -> MaterialTheme.colors.secondary
              },
              colorSurface = when (selected.value) {
                  "Semua" -> MaterialTheme.colors.primaryVariant
                  else -> MaterialTheme.colors.onSecondary
              }
          )
          Spacer(modifier = Modifier.width(6.dp))

          FilterItemRestaurant(
              name = "A",
              onClick = {
                  selected.value = "A"
                  search.value = "A"
              },
              color = when (selected.value) {
                  "A" -> MaterialTheme.colors.onSurface
                  else -> MaterialTheme.colors.secondary
              },
              colorSurface = when (selected.value) {
                  "A" -> MaterialTheme.colors.primaryVariant
                  else -> MaterialTheme.colors.onSecondary
              }
          )
          Spacer(modifier = Modifier.width(6.dp))

          FilterItemRestaurant(
              name = "B",
              onClick = {
                  selected.value = "B"
                  search.value = "B"
              },
              color = when (selected.value) {
                  "B" -> MaterialTheme.colors.onSurface
                  else -> MaterialTheme.colors.secondary
              },
              colorSurface = when (selected.value) {
                  "B" -> MaterialTheme.colors.primaryVariant
                  else -> MaterialTheme.colors.onSecondary
              }
          )
          Spacer(modifier = Modifier.width(6.dp))

          FilterItemRestaurant(
              name = "C",
              onClick = {
                  selected.value = "C"
                  search.value = "C"
              },
              color = when (selected.value) {
                  "C" -> MaterialTheme.colors.onSurface
                  else -> MaterialTheme.colors.secondary
              },
              colorSurface = when (selected.value) {
                  "C" -> MaterialTheme.colors.primaryVariant
                  else -> MaterialTheme.colors.onSecondary
              }
          )
          Spacer(modifier = Modifier.width(6.dp))

      }
      Spacer(modifier = Modifier.height(16.dp))
      FilterItemRestaurant(
          name = "Tidak Terakreditasi",
          onClick = {
              selected.value = "Tidak Terakreditasi"
              search.value = "Tidak Terakreditasi"
          },
          color = when (selected.value) {
              "Tidak Terakreditasi" -> MaterialTheme.colors.onSurface
              else -> MaterialTheme.colors.secondary
          },
          colorSurface = when (selected.value) {
              "Tidak Terakreditasi" -> MaterialTheme.colors.primaryVariant
              else -> MaterialTheme.colors.onSecondary
          }
      )

  }





}