/*
 * Copyright 2003-2023 The IdeaVim authors
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE.txt file or at
 * https://opensource.org/licenses/MIT.
 */

package com.maddyhome.idea.vim.api.stubs

import com.maddyhome.idea.vim.KeyProcessResult
import com.maddyhome.idea.vim.api.ExecutionContext
import com.maddyhome.idea.vim.api.VimEditor
import com.maddyhome.idea.vim.api.VimProcessGroupBase
import com.maddyhome.idea.vim.command.Command
import com.maddyhome.idea.vim.diagnostic.vimLogger
import com.maddyhome.idea.vim.state.mode.Mode
import javax.swing.KeyStroke

public class VimProcessGroupStub : VimProcessGroupBase() {
  init {
    vimLogger<ExecutionContextManagerStub>().warn("VimProcessGroupStub is used. Please replace it with your own implementation of VimProcessGroup.")
  }

  override val lastCommand: String
    get() = TODO("Not yet implemented")
  override var isCommandProcessing: Boolean = false
  override var modeBeforeCommandProcessing: Mode? = null

  override fun processExKey(editor: VimEditor, stroke: KeyStroke, processResultBuilder: KeyProcessResult.KeyProcessResultBuilder): Boolean {
    TODO("Not yet implemented")
  }

  public override fun startFilterCommand(editor: VimEditor, context: ExecutionContext, cmd: Command) {
    TODO("Not yet implemented")
  }

  public override fun startExCommand(editor: VimEditor, context: ExecutionContext, cmd: Command) {
    TODO("Not yet implemented")
  }

  override fun cancelExEntry(editor: VimEditor, resetCaret: Boolean) {
    TODO("Not yet implemented")
  }

  override fun executeCommand(
    editor: VimEditor,
    command: String,
    input: CharSequence?,
    currentDirectoryPath: String?,
  ): String? {
    TODO("Not yet implemented")
  }
}
