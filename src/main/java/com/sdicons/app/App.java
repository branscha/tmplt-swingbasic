/*
 * Template "tmplt-swingbasic".
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

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class App
{
    // A global index into elements of the view model.
    public static final Lib viewModel = new Lib();

    public static void main(String[] args)
    {
        constructResources();
        constructFrame();
        constructHelpSet();
        constructActions();
        constructMenu();

        final JFrame lFrame = (JFrame) viewModel.get("window.frame");
        lFrame.setVisible(true);
    }

    private static void constructFrame()
    {
        final JFrame lFrame = new JFrame((String) viewModel.get("string.title"));
        lFrame.setIconImage((Image) viewModel.get("image.crab"));

        // Install the closing mechanism on the frame when the user
        // wants to close the frame by clicking the X button.
        lFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        lFrame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                final ExitAction lExitAction = (ExitAction) viewModel.get("action.exit");
                if (lExitAction != null)
                {
                    // If there is an exit action defined, we use this action.
                    // It will have the same effect as calling the exit menu item.
                    lExitAction.actionPerformed(new ActionEvent(lFrame, 0, "exit"));
                }
                else
                {
                    // If the exit action is not available, we will close the frame anyhow.
                    lFrame.dispose();
                }
            }
        });

        // Calculate the middle of the screen.
        final Rectangle lScreenRect = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        // Using the 'golden ratio' 1.618 for the width/height ratio.
        final Rectangle lFrameRect = new Rectangle(Math.min(647, lScreenRect.width), Math.min(400, lScreenRect.height));
        // Set the window size and location.
        lFrame.setLocation((lScreenRect.width - lFrameRect.width) / 2,(lScreenRect.height - lFrameRect.height) / 2);
        lFrame.setSize(lFrameRect.width, lFrameRect.height);
        viewModel.put("window.frame", lFrame);
    }

    private static void constructResources()
    {
        viewModel.put("string.title", "Swing Basic Application");
        viewModel.put("string.version", "1.0.0");
        viewModel.put("string.copyright", "&copy; 2011, Bruno Ranschaert");

        try
        {
            final URL lImgUrl = App.class.getResource("/crab.png");
            viewModel.put("image.crab", ImageIO.read(lImgUrl));
        }
        catch (IOException e)
        {
           e.printStackTrace();
        }
    }

    private static void constructMenu()
    {
        final JFrame lFrame = (JFrame) viewModel.get("window.frame");

        final JMenuBar lMenuBar = new JMenuBar();
        lFrame.setJMenuBar(lMenuBar);
        viewModel.put("menu", lMenuBar);

        final JMenu lFileMenu = new JMenu("File");
        lFileMenu.setMnemonic(KeyEvent.VK_F);
        viewModel.put("menu.file", lFileMenu);
        lMenuBar.add(lFileMenu);

        final JMenuItem lExitItem = new JMenuItem((Action) viewModel.get("action.exit"));
        viewModel.put("menu.file.exit", lExitItem);
        lFileMenu.add(lExitItem);

        final JMenuItem lHelpMenu = new JMenu("Help");
        lHelpMenu.setMnemonic(KeyEvent.VK_H);
        viewModel.put("menu.help", lHelpMenu);
        lMenuBar.add(lHelpMenu);

        final JMenuItem lHelpTopicsItem = new JMenuItem((Action) viewModel.get("action.help"));
        viewModel.put("menu.help.topics", lHelpTopicsItem);
        lHelpMenu.add(lHelpTopicsItem);

        final JMenuItem lAboutItem = new JMenuItem((Action) viewModel.get("action.about"));
        viewModel.put("menu.help.about", lAboutItem);
        lHelpMenu.add(lAboutItem);
    }

    private static void constructActions()
    {
        final Action lExitAction = new ExitAction();
        lExitAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
        viewModel.put("action.exit", lExitAction);

        final Action lHelpAction = new HelpAction();
        lHelpAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_T);
        viewModel.put("action.help", lHelpAction);

        final Action lAboutAction = new AboutAction();
        lAboutAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
        viewModel.put("action.about", lAboutAction);
    }

    private static void constructHelpSet()
    {
        try
        {
            final ClassLoader lLoader = App.class.getClassLoader();
            final URL lUrl = HelpSet.findHelpSet(lLoader, "apphelp.hs");
            final HelpSet lHelpSet = new HelpSet(lLoader, lUrl);
            final HelpBroker lHelpBroker = lHelpSet.createHelpBroker();
            viewModel.put("help", lHelpBroker);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
