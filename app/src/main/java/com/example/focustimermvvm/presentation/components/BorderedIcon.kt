package com.example.focustimermvvm.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustimermvvm.R

import com.example.focustimermvvm.presentation.theme.FocusTimerMVVMTheme


@Composable
fun BorderedIcon (
    modifier: Modifier = Modifier,
    @DrawableRes icon : Int,
    onTap : () -> Unit = {}

) {
    Box(
        modifier = modifier
            .size(FocusTimerMVVMTheme.dimens.iconSizeNormal)
            .border(width = FocusTimerMVVMTheme.dimens.borderNormal,
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
            .clip(CircleShape)
            .clickable {onTap()},
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(FocusTimerMVVMTheme.dimens.iconSizeSmall),
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BorderedIconPreview() {
    BorderedIcon(icon = R.drawable.ic_launcher_foreground)
}
