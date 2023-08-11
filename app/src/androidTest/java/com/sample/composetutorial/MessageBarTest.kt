package com.sample.composetutorial

import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sample.composetutorial.messagebar.model.MessageBarState
import com.sample.composetutorial.messagebar.model.TestTags.COPY_BUTTON
import com.sample.composetutorial.messagebar.model.TestTags.MESSAGE_BAR
import com.sample.composetutorial.messagebar.model.TestTags.MESSAGE_BAR_TEXT
import com.sample.composetutorial.messagebar.screen.ContentWithMessageBar
import com.sample.composetutorial.messagebar.screen.rememberMessageBarState
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MessageBarTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    private lateinit var state: MessageBarState

    private lateinit var clipboardManager: ClipboardManager

    @Before
    fun setup() {
        composeTestRule.setContent {
            clipboardManager = LocalClipboardManager.current
            state = rememberMessageBarState()
            ContentWithMessageBar(messageBarState = state) {}
        }
    }

    @Test
    fun addNoState_Assert_MessageBarDoesNotExist() {
        composeTestRule.onNodeWithTag(MESSAGE_BAR).assertDoesNotExist()
    }

    @Test
    fun addSuccessState_Assert_CorrectSuccessMessageIsDisplayed() {
        state.addSuccess("Success Message!")
        composeTestRule.onNodeWithTag(MESSAGE_BAR_TEXT).assertTextEquals("Success Message!")
        composeTestRule.onNodeWithTag(COPY_BUTTON).assertDoesNotExist()
    }

    @Test
    fun addSuccessState_Assert_CorrectErrorMessageIsDisplayed() {
        state.addError(Exception("error"))
        composeTestRule.onNodeWithTag(MESSAGE_BAR_TEXT).assertTextEquals("error")
        composeTestRule.onNodeWithTag(COPY_BUTTON).assertExists()
    }

    @Test
    fun addSuccessState_Assert_CorrectMessageCopiedToClipBoard() {
        state.addError(Exception("error"))
        composeTestRule.onNodeWithTag(COPY_BUTTON).performClick()
        assert(clipboardManager.getText()?.text == "error")
    }
}