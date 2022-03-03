package com.db8.db8admin.data.ui

import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.db8.db8admin.data.home.models.KeywordRequest
import com.db8.db8admin.data.repository.CommonRepository
import com.db8.db8admin.utils.PreferenceStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommonViewModel @Inject constructor(
    private val repo: CommonRepository,
    private val store: PreferenceStore
) : ViewModel() {

    val getAllKeyword = repo.getAllKeywords()

    fun setPref(key: Preferences.Key<String>, value: String) = viewModelScope.launch {
        store.setPref(key, value)
    }

    fun getPref(key: Preferences.Key<String>) = store.getPref(key)

}