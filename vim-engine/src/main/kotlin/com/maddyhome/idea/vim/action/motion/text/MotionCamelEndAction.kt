/*
 * Copyright 2003-2023 The IdeaVim authors
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE.txt file or at
 * https://opensource.org/licenses/MIT.
 */
package com.maddyhome.idea.vim.action.motion.text

import com.maddyhome.idea.vim.api.ExecutionContext
import com.maddyhome.idea.vim.api.ImmutableVimCaret
import com.maddyhome.idea.vim.api.VimEditor
import com.maddyhome.idea.vim.api.injector
import com.maddyhome.idea.vim.command.Argument
import com.maddyhome.idea.vim.command.MotionType
import com.maddyhome.idea.vim.command.OperatorArguments
import com.maddyhome.idea.vim.common.Direction
import com.maddyhome.idea.vim.handler.Motion
import com.maddyhome.idea.vim.handler.MotionActionHandler
import com.maddyhome.idea.vim.handler.toMotionOrError

public class MotionCamelEndLeftAction : MotionCamelEndAction(Direction.BACKWARDS)
public class MotionCamelEndRightAction : MotionCamelEndAction(Direction.FORWARDS)

public sealed class MotionCamelEndAction(public val direction: Direction) : MotionActionHandler.ForEachCaret() {
  override fun getOffset(
    editor: VimEditor,
    caret: ImmutableVimCaret,
    context: ExecutionContext,
    argument: Argument?,
    operatorArguments: OperatorArguments,
  ): Motion {
    return moveCaretToNextCamelEnd(editor, caret, direction.toInt() * operatorArguments.count1).toMotionOrError()
  }

  override val motionType: MotionType = MotionType.INCLUSIVE
}

private fun moveCaretToNextCamelEnd(editor: VimEditor, caret: ImmutableVimCaret, count: Int): Int {
  return if (caret.offset.point == 0 && count < 0 || caret.offset.point >= editor.fileSize() - 1 && count > 0) {
    -1
  } else {
    injector.searchHelper.findNextCamelEnd(editor, caret, count)
  }
}
