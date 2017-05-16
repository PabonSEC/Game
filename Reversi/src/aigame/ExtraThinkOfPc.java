/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aigame;

import static aigame.AIgame.*;
import static aigame.PC.MxposX;
import static aigame.PC.MxposY;
import static aigame.PC.MnposX;
import static aigame.PC.MnposY;

/**
 *
 * @author Shahnawaz Hossan
 */
public class ExtraThinkOfPc {

    static int[][] PossibleMove = new int[8][8];

    static int[][][] BackDir = new int[8][8][8];

    int PC, User, mx = 0, mn = 100000;

    void perform() {

        int i, j, k;

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                PossibleMove[i][j] = track[i][j];
            }
        }

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (PossibleMove[i][j] == -2) {

                    System.out.print("  " + PossibleMove[i][j]);

                } else if (PossibleMove[i][j] == -1) {

                    System.out.print("  " + PossibleMove[i][j]);
                } else {
                    System.out.print("   " + PossibleMove[i][j]);
                }
            }

            System.out.println("");
        }

        // Check User's Next Possible Move
        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (track[i][j] > 0) {

                    if ((i == 0 && j == 0) || (i == 0 && j == 7) || (i == 7 && j == 0) || (i == 7 && j == 7)) {

                        MxposX = i;

                        MxposY = j;

                        return;

                    }

                    PC = track[i][j];

                    //System.out.print("PC = "+PC);
                    PossibleMove[i][j] = -2;

                    //To Down
                    if (dir[i][j][0] == 1) {

                        //System.out.println("down");
                        for (int p = i + 1; p < 8; p++) {

                            if (PossibleMove[p][j] == -1) {

                                //btn[p][j].setIcon(pc);
                                //btn[p][j].setEnabled(false);
                                //FinalColor[p][j] = true;
                                PossibleMove[p][j] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    // To Up
                    if (dir[i][j][1] == 1) {

                        //System.out.println("up");
                        for (int p = i - 1; p >= 0; p--) {

                            if (PossibleMove[p][j] == -1) {

                                // btn[p][j].setIcon(pc);
                                //btn[p][j].setEnabled(false);
                                //FinalColor[p][j] = true;
                                PossibleMove[p][j] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    //System.out.println("dir "+dir[r][c][2]);
                    // To Right
                    if (dir[i][j][2] == 1) {

                        //System.out.println("right");
                        for (int p = j + 1; p < 8; p++) {

                            //System.out.println("r "+r+", p "+p);
                            if (PossibleMove[i][p] == -1) {

                                //btn[i][p].setIcon(pc);
                                //btn[i][p].setEnabled(false);
                                //FinalColor[i][p] = true;
                                PossibleMove[i][p] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    //System.out.println("dir = " + dir[i][j][3]);
                    // To Left
                    if (dir[i][j][3] == 1) {

                        //System.out.println("left");
                        for (int p = j - 1; p >= 0; p--) {

                            if (PossibleMove[i][p] == -1) {

                                //btn[i][p].setIcon(pc);
                                //btn[i][p].setEnabled(false);
                                //FinalColor[i][p] = true;
                                PossibleMove[i][p] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    // To LeftUp
                    if (dir[i][j][4] == 1) {

                        //System.out.println("leftup");
                        for (int p = i - 1, q = j - 1; p >= 0 && q >= 0; p--, q--) {

                            if (PossibleMove[p][q] == -1) {

                                //btn[p][q].setIcon(pc);
                                //btn[p][q].setEnabled(false);
                                //FinalColor[p][q] = true;
                                PossibleMove[p][q] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    // To RightDown
                    if (dir[i][j][5] == 1) {

                        //System.out.println("rightdown");
                        for (int p = i + 1, q = j + 1; p < 8 && q < 8; p++, q++) {

                            if (PossibleMove[p][q] == -1) {

                                //btn[p][q].setIcon(pc);
                                //btn[p][q].setEnabled(false);
                                //FinalColor[p][q] = true;
                                PossibleMove[p][q] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    // To RightUp
                    if (dir[i][j][6] == 1) {

                        //System.out.println("rightup");
                        for (int p = i - 1, q = j + 1; p >= 0 && q < 8; p--, q++) {

                            if (PossibleMove[p][q] == -1) {

                                //btn[p][q].setIcon(pc);
                                //btn[p][q].setEnabled(false);
                                //FinalColor[p][q] = true;
                                PossibleMove[p][q] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    // To LeftDown
                    if (dir[i][j][7] == 1) {

                        //System.out.println("leftdown");
                        for (int p = i + 1, q = j - 1; p < 8 && q >= 0; p++, q--) {

                            if (PossibleMove[p][q] == -1) {

                                //btn[p][q].setIcon(pc);
                                //btn[p][q].setEnabled(false);
                                //FinalColor[p][q] = true;
                                PossibleMove[p][q] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    initPossibleMove();

                    User = CountTotalUser();

                    System.out.println("PC " + track[i][j] + ", User " + User + " , pos " + i + " , " + j);

                    //System.out.println("Position = "+i+" , "+j);
                    int sub, sub1;

                    if (PC > User) {

                        sub = PC - User;

                        if (mx < sub) {

                            mx = sub;

                            MxposX = i;

                            MxposY = j;

                            //System.out.println("*** "+i+","+j);
                        }

                    } else {

                        sub1 = User - PC;

                        if (mn > sub1) {

                            mn = sub1;

                            MnposX = i;

                            MnposY = j;
                        }

                    }

                    BackToPrevious();

                } // End of Main Condition

            }// End of 2nd Loop

        }// End of 1st Loop

        System.out.println("Extra call korar por");

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (PossibleMove[i][j] == -2) {

                    System.out.print("  " + PossibleMove[i][j]);

                } else if (PossibleMove[i][j] == -1) {

                    System.out.print("  " + PossibleMove[i][j]);
                } else {
                    System.out.print("   " + PossibleMove[i][j]);
                }

//                if (track[i][j] > 0) {
//
//                    if (mx < track[i][j]) {
//
//                        mx = track[i][j];
//
//                    }
//
//                }
            }

            System.out.println("");
        }

    }

    void initPossibleMove() {

        int i, j;

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (PossibleMove[i][j] > 0) {

                    PossibleMove[i][j] = 0;
                }

            }
        }

    }

    int CountTotalUser() {

        int i, j, mx = 0;

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (PossibleMove[i][j] == -1) {

                    //System.out.println("i = "+i+" j= "+j);
                    int cnt = 0;

                    // To Up
                    for (int y = i - 1; y >= 0; y--) {

                        if (PossibleMove[y][j] == -2) {
                            cnt++;
                        } else if (PossibleMove[y][j] >= 0 && cnt > 0) {
                            PossibleMove[y][j] += cnt;
                            //dir[y][j][0] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To Right
                    for (int y = j + 1; y < 8; y++) {

                        if (PossibleMove[i][y] == -2) {
                            cnt++;
                        } else if (PossibleMove[i][y] >= 0 && cnt > 0) {
                            PossibleMove[i][y] += cnt;
                            //dir[i][y][3] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To Down
                    for (int y = i + 1; y < 8; y++) {

                        if (PossibleMove[y][j] == -2) {
                            cnt++;
                        } else if (PossibleMove[y][j] >= 0 && cnt > 0) {
                            PossibleMove[y][j] += cnt;
                            //dir[y][j][1] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To Left
                    for (int y = j - 1; y >= 0; y--) {

                        if (PossibleMove[i][y] == -2) {
                            cnt++;
                        } else if (PossibleMove[i][y] >= 0 && cnt > 0) {
                            PossibleMove[i][y] += cnt;
                            //dir[i][y][2] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To UpperLeft
                    for (int y = i - 1, z = j - 1; y >= 0 && z >= 0; y--, z--) {

                        if (PossibleMove[y][z] == -2) {
                            cnt++;
                        } else if (PossibleMove[y][z] >= 0 && cnt > 0) {
                            PossibleMove[y][z] += cnt;
                            //dir[y][z][5] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To LowerRight
                    for (int y = i + 1, z = j + 1; y < 8 && z < 8; y++, z++) {

                        if (PossibleMove[y][z] == -2) {
                            cnt++;
                        } else if (PossibleMove[y][z] >= 0 && cnt > 0) {
                            PossibleMove[y][z] += cnt;
                            //dir[y][z][4] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To UpperRight
                    for (int y = i - 1, z = j + 1; y >= 0 && z < 8; y--, z++) {

                        if (PossibleMove[y][z] == -2) {
                            cnt++;
                        } else if (PossibleMove[y][z] >= 0 && cnt > 0) {
                            PossibleMove[y][z] += cnt;
                            //dir[y][z][7] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To LowerLeft
                    for (int y = i + 1, z = j - 1; y < 8 && z >= 0; y++, z--) {

                        if (PossibleMove[y][z] == -2) {
                            cnt++;
                        } else if (PossibleMove[y][z] >= 0 && cnt > 0) {
                            PossibleMove[y][z] += cnt;
                            //dir[y][z][6] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                }

            }//End of 2nd Loop

        }//End Of 1st Loop

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (PossibleMove[i][j] > 0) {

                    if (mx < PossibleMove[i][j]) {

                        mx = PossibleMove[i][j];
                    }
                }

            }

        }

        return mx;
    }

    void BackToPrevious() {

        int i, j;

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                PossibleMove[i][j] = track[i][j];
            }

        }

    }
}
