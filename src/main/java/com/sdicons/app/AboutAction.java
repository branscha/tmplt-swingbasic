/*
 * Copyright (c) 2011 Bruno Ranschaert, SDI-Consulting BVBA.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.sdicons.app;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AboutAction
extends AbstractAction
{
    public AboutAction() {super("About");}

    public void actionPerformed(ActionEvent e)
    {
        final StringBuilder lBuf = new StringBuilder();
        lBuf.
                append("<html><p align=center>").
                append("<font size=+1>").append(App.viewModel.get("string.title")).append("</font>").append("<br>").
                append("version ").append(App.viewModel.get("string.version")).append("<br>").
                append(App.viewModel.get("string.copyright")).append("</html>");

        JOptionPane.showMessageDialog((JFrame) App.viewModel.get("window.frame"), lBuf.toString(), "About", JOptionPane.INFORMATION_MESSAGE);
    }
}