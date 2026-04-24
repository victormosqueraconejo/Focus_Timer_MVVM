package com.example.focustimermvvm.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustimermvvm.R
import com.example.focustimermvvm.presentation.components.AutoResizedText
import com.example.focustimermvvm.presentation.components.BorderedIcon
import com.example.focustimermvvm.presentation.components.CircleDot
import com.example.focustimermvvm.presentation.components.CustomButton
import com.example.focustimermvvm.presentation.components.InformationItem
import com.example.focustimermvvm.presentation.components.TimerTypeItem
import com.example.focustimermvvm.presentation.theme.FocusTimerMVVMTheme


@Composable
fun HomeScreen (

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(FocusTimerMVVMTheme.dimens.paddingMedium)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd,
            ) {
            Icon(
                modifier = Modifier.size(FocusTimerMVVMTheme.dimens.iconSizeNormal),
                contentDescription = "Menu",
                painter = painterResource(R.drawable.ic_menu),
                tint = MaterialTheme.colorScheme.primary
            )

        }

        AutoResizedText(text = "Focus Timer",
            textStyle = MaterialTheme.typography.displayMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            ))

        Spacer(
            modifier = Modifier.height(FocusTimerMVVMTheme.dimens.spacerMedium)
        )


        Row(
            modifier = Modifier
        ) {
            CircleDot()
            Spacer(modifier = Modifier.width(FocusTimerMVVMTheme.dimens.spacerNormal))

            CircleDot()
            Spacer(modifier = Modifier.width(FocusTimerMVVMTheme.dimens.spacerNormal))

            CircleDot(
                color  = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.width(FocusTimerMVVMTheme.dimens.spacerNormal))
            CircleDot(
                color  = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.width(FocusTimerMVVMTheme.dimens.spacerNormal))
        }

        Spacer(
            modifier = Modifier.height(FocusTimerMVVMTheme.dimens.spacerMedium)
        )

        TimerSession(
            timer = "05:00",
            onDecreseTap = {
                // TODO:
            },
            onIncreseTap = {
                // TODO:
            }
        )

        Spacer(
            modifier = Modifier.height(FocusTimerMVVMTheme.dimens.spacerMedium)
        )

        TimerTypeSession(
            onTap = {
                // TODO:
            }
        )
        Spacer(
            modifier = Modifier.height(FocusTimerMVVMTheme.dimens.spacerMedium)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomButton(
                text = "Start",
                textColor = MaterialTheme.colorScheme.surface,
                buttonColor = MaterialTheme.colorScheme.primary,
                onTab = {
                    TODO()
                }

            )
            CustomButton(
                text = "Reset",
                textColor = MaterialTheme.colorScheme.primary,
                buttonColor = MaterialTheme.colorScheme.surface,
                onTab = {
                    TODO()
                }

            )

        }
        Spacer(
            modifier = Modifier.height(FocusTimerMVVMTheme.dimens.spacerMedium)
        )

        InformationSession(
            modifier = Modifier.weight(1f),
            round = "10",
            time = "45:00"
        )



    }

}


@Composable
fun TimerSession(
    modifier: Modifier = Modifier,
    timer : String,
    onIncreseTap : () -> Unit = {},
    onDecreseTap: () -> Unit = {}

) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorderedIcon(icon = R.drawable.ic_minus, onTap = onDecreseTap)
        }

        AutoResizedText(
            text = timer,
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
                .align(alignment = Alignment.CenterVertically),
            textStyle = MaterialTheme.typography.displayLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorderedIcon(icon = R.drawable.ic_plus, onTap = onIncreseTap)
        }
    }

}


@Composable
fun TimerTypeSession(
    modifier: Modifier = Modifier,
    onTap: () -> Unit = {}
) {

    val gridCount = 3

    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .height(FocusTimerMVVMTheme.dimens.spacerLarge),
        columns = GridCells.Fixed(gridCount),
        horizontalArrangement = Arrangement.spacedBy(FocusTimerMVVMTheme.dimens.paddingNormal),
        verticalArrangement = Arrangement.spacedBy(FocusTimerMVVMTheme.dimens.paddingNormal)
    ) {
        item (
            key = "FB"
        ) {
            TimerTypeItem(
                text = "Focus Break",
                textColor = MaterialTheme.colorScheme.primary
            )
        }

        item (
            key = "LB"
        ) {
            TimerTypeItem(
                text = "Long Break",
                textColor = MaterialTheme.colorScheme.secondary
            )
        }

        item (
            key = "SB"
        ) {
            TimerTypeItem(
                text = "Short Break",
                textColor = MaterialTheme.colorScheme.secondary
            )
        }
    }

}



@Composable
fun InformationSession(
    modifier: Modifier = Modifier,
    round: String,
    time: String
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier.align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            InformationItem(
                modifier = Modifier.weight(1f),
                text = round,
                label = "rounds"
            )

            Spacer(modifier = Modifier.weight(1f))

            InformationItem(
                modifier = Modifier.weight(1f),
                text = time,
                label = "time"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    FocusTimerMVVMTheme(
        content = {
            HomeScreen()
        }
    )
}