package app.revanced.manager.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.revanced.manager.R
import app.revanced.manager.ui.component.SocialItem
import app.revanced.manager.ui.navigation.AppDestination
import app.revanced.manager.ui.viewmodel.SettingsViewModel
import com.xinto.taxi.BackstackNavigator
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = getViewModel(),
    navigator: BackstackNavigator<AppDestination>
) {
    val prefs = viewModel.prefs
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier,
        topBar = {
            MediumTopAppBar(
                title = { Text(stringResource(R.string.settings)) },
                navigationIcon = {
                    IconButton(onClick = navigator::pop) {
                        Icon(
                            imageVector = Icons.Default.NavigateBefore,
                            contentDescription = null
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ListItem(
                modifier = Modifier.clickable { prefs.dynamicColor = !prefs.dynamicColor },
                headlineText = { Text(stringResource(R.string.dynamic_color)) },
                trailingContent = {
                    Switch(
                        checked = prefs.dynamicColor,
                        onCheckedChange = { prefs.dynamicColor = it }
                    )
                }
            )

            Divider()
            SocialItem(R.string.github, Icons.Default.Code, viewModel::openGitHub)
        }
    }
}