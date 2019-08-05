package com.noile.sea_battle.logic;

import com.noile.sea_battle.logic.ships.Ships;
import com.noile.sea_battle.view.CellPane;

import java.awt.*;
import java.util.ArrayList;

public class PutShip {

    ArrayList<CellPane> fieldPanelList;

    private Ships classShips;
    private boolean checkPosition;
    private boolean checkClassShip;
    private int position;
    private int axis;

    public PutShip(ArrayList<CellPane> fieldPanelList) {
        this.fieldPanelList = fieldPanelList;
        checkPosition = true;
        checkClassShip = true;
    }

    public void putShip() {
        if (classShips != null) {
            if (getAxis() == 0) {
                putShipAxisX();
                setClassShips(null);
                checkPosition = true;
            }
            if (getAxis() == 1) {
                putShipAxisY();
                setClassShips(null);
                checkPosition = true;
            }
        }
    }

    public void putShipAxisX() {
        checkClassShipX();
        checkPositionAxisX();
        if ((classShips.getSize() == 1 || classShips.getSize() == 2 || classShips.getSize() == 3 || classShips.getSize() == 4) & (checkPosition & checkClassShip)) {
            fieldPanelList.get(position).setCellClassShip();
            fieldPanelList.get(position).reloadStateCell();
            fieldPanelList.get(position).setShipViewIcon();
            if (classShips.getSize() == 2 || classShips.getSize() == 3 || classShips.getSize() == 4) {
                fieldPanelList.get(position + 1).setCellClassShip();
                fieldPanelList.get(position + 1).reloadStateCell();
                fieldPanelList.get(position + 1).setShipViewIcon();
                if (classShips.getSize() == 3 || classShips.getSize() == 4) {
                    fieldPanelList.get(position + 2).setCellClassShip();
                    fieldPanelList.get(position + 2).reloadStateCell();
                    fieldPanelList.get(position + 2).setShipViewIcon();
                    if (classShips.getSize() == 4) {
                        fieldPanelList.get(position + 3).setCellClassShip();
                        fieldPanelList.get(position + 3).reloadStateCell();
                        fieldPanelList.get(position + 3).setShipViewIcon();
                    }
                }
            }
        } else {
            System.out.println("Error");
        }

    }

    public void putShipAxisY() {
        checkClassShipY();
        checkPositionAxisY();
        if ((classShips.getSize() == 1 || classShips.getSize() == 2 || classShips.getSize() == 3 || classShips.getSize() == 4) & (checkPosition & checkClassShip)) {
            fieldPanelList.get(position).setCellClassShip();
            fieldPanelList.get(position).reloadStateCell();
            fieldPanelList.get(position).setShipViewIcon();
            if (classShips.getSize() == 2 || classShips.getSize() == 3 || classShips.getSize() == 4) {
                fieldPanelList.get(position + 10).setCellClassShip();
                fieldPanelList.get(position + 10).reloadStateCell();
                fieldPanelList.get(position + 10).setShipViewIcon();
                if (classShips.getSize() == 3 || classShips.getSize() == 4) {
                    fieldPanelList.get(position + 20).setCellClassShip();
                    fieldPanelList.get(position + 20).reloadStateCell();
                    fieldPanelList.get(position + 20).setShipViewIcon();
                    if (classShips.getSize() == 4) {
                        fieldPanelList.get(position + 30).setCellClassShip();
                        fieldPanelList.get(position + 30).reloadStateCell();
                        fieldPanelList.get(position + 30).setShipViewIcon();
                    }
                }
            }
        } else {
            System.out.println("Error");
        }
    }

    public void checkClassShipX() {
        checkClassShip = true;
        if (position == 99) {
        } else {
            if (fieldPanelList.get(position).getCellClassShip() != null & (classShips.getSize() == 1 ||
                    classShips.getSize() == 2 || classShips.getSize() == 3 || classShips.getSize() == 4)) {
                checkClassShip = false;
                fieldPanelList.get(position + 1).getDefaultBackground();
                fieldPanelList.get(position + 2).getDefaultBackground();
                fieldPanelList.get(position + 3).getDefaultBackground();
            } else {
                if (fieldPanelList.get(position + 1).getCellClassShip() != null & (classShips.getSize() == 2 ||
                        classShips.getSize() == 3 || classShips.getSize() == 4)) {
                    checkClassShip = false;
                    fieldPanelList.get(position + 1).getDefaultBackground();
                    fieldPanelList.get(position + 2).getDefaultBackground();
                    fieldPanelList.get(position + 3).getDefaultBackground();
                } else {
                    if (fieldPanelList.get(position + 2).getCellClassShip() != null & (classShips.getSize() == 3 || classShips.getSize() == 4)) {
                        checkClassShip = false;
                        fieldPanelList.get(position + 1).getDefaultBackground();
                        fieldPanelList.get(position + 2).getDefaultBackground();
                        fieldPanelList.get(position + 3).getDefaultBackground();
                    } else {
                        if (fieldPanelList.get(position + 3).getCellClassShip() != null & classShips.getSize() == 4) {
                            checkClassShip = false;
                            fieldPanelList.get(position + 1).getDefaultBackground();
                            fieldPanelList.get(position + 2).getDefaultBackground();
                            fieldPanelList.get(position + 3).getDefaultBackground();
                        }
                    }
                }
            }
        }
    }

    public void checkClassShipY() {
        checkClassShip = true;
        if (position <= 99 && fieldPanelList.get(position).getCellClassShip() != null) {
            checkClassShip = false;
            System.out.println("Test 2");
        } else {
            if (position + 10 < 99 && fieldPanelList.get(position + 10).getCellClassShip() != null) {
                checkClassShip = false;
                fieldPanelList.get(position + 10).getDefaultBackground();
                fieldPanelList.get(position + 20).getDefaultBackground();
                fieldPanelList.get(position + 30).getDefaultBackground();
            } else {
                if (position + 20 < 99 && fieldPanelList.get(position + 20).getCellClassShip() != null) {
                    checkClassShip = false;
                    fieldPanelList.get(position + 10).getDefaultBackground();
                    fieldPanelList.get(position + 20).getDefaultBackground();
                    fieldPanelList.get(position + 30).getDefaultBackground();
                } else {
                    if (position + 30 < 99 && fieldPanelList.get(position + 30).getCellClassShip() != null) {
                        checkClassShip = false;
                        fieldPanelList.get(position + 10).getDefaultBackground();
                        fieldPanelList.get(position + 20).getDefaultBackground();
                        fieldPanelList.get(position + 30).getDefaultBackground();
                    }
                }
            }
        }
    }

    public void checkPositionAxisX() {
        if (classShips.getSize() == 1) {
        } else {
            if (position == 99) {
                checkPosition = false;
            } else {
                if ((position + 1 == 10 | position + 1 == 20 | position + 1 == 30 | position + 1 == 40 | position + 1 == 50 | position + 1 == 60 |
                        position + 1 == 70 | position + 1 == 80 | position + 1 == 90 | position + 1 > 99) & (classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4)) {
                    checkPosition = false;
                } else {
                    fieldPanelList.get(position + 1).getDefaultBackground();
                    if ((position + 2 == 10 | position + 2 == 20 | position + 2 == 30 | position + 2 == 40 | position + 2 == 50 | position + 2 == 60 |
                            position + 2 == 70 | position + 2 == 80 | position + 2 == 90 | position + 2 > 99) & (classShips.getSize() == 3 | classShips.getSize() == 4)) {
                        checkPosition = false;
                    } else {
                        if ((position + 3 == 10 | position + 3 == 20 | position + 3 == 30 | position + 3 == 40 | position + 3 == 50 | position + 3 == 60 |
                                position + 3 == 70 | position + 3 == 80 | position + 3 == 90 | position + 3 > 99) & (classShips.getSize() == 4)) {
                            checkPosition = false;
                            fieldPanelList.get(position + 2).getDefaultBackground();
                        }
                    }
                }
            }
        }
    }

    public void checkPositionAxisY() {
        if (classShips.getSize() == 1) {
        } else {
            if ((position == 90 | position == 91 | position == 92 | position == 93 | position == 94 | position == 95 | position == 96 |
                    position == 97 | position == 98 | position == 99) & (classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4)) {
                checkPosition = false;
            } else {
                if (classShips.getSize() == 2) {
                } else {
                    if ((position + 10 == 90 | position + 10 == 91 | position + 10 == 92 | position + 10 == 93 | position + 10 == 94 | position + 10 == 95 | position + 10 == 96 |
                            position + 10 == 97 | position + 10 == 98 | position + 10 == 99) & (classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4)) {
                        checkPosition = false;
                        fieldPanelList.get(position + 10).getDefaultBackground();
                    } else {
                        if (classShips.getSize() == 3) {
                        } else {
                            if ((position + 20 == 90 | position + 20 == 91 | position + 20 == 92 | position + 20 == 93 | position + 20 == 94 | position + 20 == 95 | position + 20 == 96 |
                                    position + 20 == 97 | position + 20 == 98 | position + 20 == 99) & (classShips.getSize() == 3 | classShips.getSize() == 4)) {
                                checkPosition = false;
                                fieldPanelList.get(position + 10).getDefaultBackground();
                                fieldPanelList.get(position + 20).getDefaultBackground();
                            }
                        }
                    }
                }
            }
        }
    }


    public void entered() {
        checkColor();
        if (axis == 1) {
            if (classShips != null) {
                if ((classShips.getSize() == 1 | classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                        position < fieldPanelList.size()) {
                    fieldPanelList.get(position).setDefaultBackground();
                    fieldPanelList.get(position).setBackground(fieldPanelList.get(position).getCellColor());
                    if ((classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                            position + 10 < fieldPanelList.size()) {
                        fieldPanelList.get(position + 10).setDefaultBackground();
                        fieldPanelList.get(position + 10).setBackground(fieldPanelList.get(position + 10).getCellColor());
                        if ((classShips.getSize() == 3 | classShips.getSize() == 4) &
                                position + 20 < fieldPanelList.size()) {
                            fieldPanelList.get(position + 20).setDefaultBackground();
                            fieldPanelList.get(position + 20).setBackground(fieldPanelList.get(position + 20).getCellColor());
                            if (classShips.getSize() == 4 &
                                    position + 30 < fieldPanelList.size()) {
                                fieldPanelList.get(position + 30).setDefaultBackground();
                                fieldPanelList.get(position + 30).setBackground(fieldPanelList.get(position + 30).getCellColor());
                            }
                        }
                    }
                }
            } else {
                fieldPanelList.get(position).setDefaultBackground();
                fieldPanelList.get(position).setBackground(Color.BLUE);
            }
        }
        if (axis == 0) {
            if (classShips != null) {
                if ((classShips.getSize() == 1 | classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                        position < fieldPanelList.size()) {
                    if (position == 9 || position == 19 || position == 29 || position == 39 || position == 49 || position == 59 ||
                            position == 69 || position == 79 || position == 89 || position == 99) {
                        fieldPanelList.get(position).setDefaultBackground();
                        fieldPanelList.get(position).setBackground(fieldPanelList.get(position).getCellColor());
                    } else {
                        fieldPanelList.get(position).setDefaultBackground();
                        fieldPanelList.get(position).setBackground(fieldPanelList.get(position).getCellColor());
                        if ((classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                                position + 1 < fieldPanelList.size()) {
                            if (position + 1 == 9 || position + 1 == 19 || position + 1 == 29 || position + 1 == 39 || position + 1 == 49 || position + 1 == 59 ||
                                    position + 1 == 69 || position + 1 == 79 || position + 1 == 89 || position + 1 == 99) {
                                fieldPanelList.get(position + 1).setDefaultBackground();
                                fieldPanelList.get(position + 1).setBackground(fieldPanelList.get(position + 1).getCellColor());
                            } else {
                                fieldPanelList.get(position + 1).setDefaultBackground();
                                fieldPanelList.get(position + 1).setBackground(fieldPanelList.get(position + 1).getCellColor());
                                if ((classShips.getSize() == 3 | classShips.getSize() == 4) &
                                        position + 2 < fieldPanelList.size()) {
                                    if (position + 2 == 9 || position + 2 == 19 || position + 2 == 29 || position + 2 == 39 || position + 2 == 49 || position + 2 == 59 ||
                                            position + 2 == 69 || position + 2 == 79 || position + 2 == 89 || position + 2 == 99) {
                                        fieldPanelList.get(position + 2).setDefaultBackground();
                                        fieldPanelList.get(position + 2).setBackground(fieldPanelList.get(position + 2).getCellColor());
                                    } else {
                                        fieldPanelList.get(position + 2).setDefaultBackground();
                                        fieldPanelList.get(position + 2).setBackground(fieldPanelList.get(position + 2).getCellColor());
                                        if (classShips.getSize() == 4 &
                                                position + 3 < fieldPanelList.size()) {
                                            if (position + 3 == 9 || position + 3 == 19 || position + 3 == 29 || position + 3 == 39 || position + 3 == 49 || position + 3 == 59 ||
                                                    position + 3 == 69 || position + 3 == 79 || position + 3 == 89 || position + 3 == 99) {
                                                fieldPanelList.get(position + 3).setDefaultBackground();
                                                fieldPanelList.get(position + 3).setBackground(fieldPanelList.get(position + 1).getCellColor());
                                            } else {
                                                fieldPanelList.get(position + 3).setDefaultBackground();
                                                fieldPanelList.get(position + 3).setBackground(fieldPanelList.get(position + 1).getCellColor());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                fieldPanelList.get(position).setDefaultBackground();
                fieldPanelList.get(position).setBackground(Color.BLUE);
            }
        }
    }

    public void exited() {
        if (axis == 1) {
            if (classShips != null) {
                if ((classShips.getSize() == 1 | classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                        position < fieldPanelList.size()) {
                    fieldPanelList.get(position).getDefaultBackground();
                    fieldPanelList.get(position).setColorGreen();
                    if ((classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                            position + 10 < fieldPanelList.size()) {
                        fieldPanelList.get(position + 10).getDefaultBackground();
                        fieldPanelList.get(position + 10).setColorGreen();
                        if ((classShips.getSize() == 3 | classShips.getSize() == 4) &
                                position + 20 < fieldPanelList.size()) {
                            fieldPanelList.get(position + 20).getDefaultBackground();
                            fieldPanelList.get(position + 20).setColorGreen();
                            if (classShips.getSize() == 4 &
                                    position + 30 < fieldPanelList.size()) {
                                fieldPanelList.get(position + 30).getDefaultBackground();
                                fieldPanelList.get(position + 30).setColorGreen();
                            }
                        }
                    }
                }
            } else {
                fieldPanelList.get(position).getDefaultBackground();
            }
        }
        if (axis == 0) {
            if (classShips != null) {
                if ((classShips.getSize() == 1 | classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                        position < fieldPanelList.size()) {
                    fieldPanelList.get(position).getDefaultBackground();
                    fieldPanelList.get(position).setColorGreen();
                    if ((classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                            position + 1 < fieldPanelList.size()) {
                        fieldPanelList.get(position + 1).getDefaultBackground();
                        fieldPanelList.get(position + 1).setColorGreen();
                        if ((classShips.getSize() == 3 | classShips.getSize() == 4) &
                                position + 2 < fieldPanelList.size()) {
                            fieldPanelList.get(position + 2).getDefaultBackground();
                            fieldPanelList.get(position + 2).setColorGreen();
                            if (classShips.getSize() == 4 &
                                    position + 3 < fieldPanelList.size()) {
                                fieldPanelList.get(position + 3).getDefaultBackground();
                                fieldPanelList.get(position + 3).setColorGreen();

                            }
                        }
                    }
                }
            } else {
                fieldPanelList.get(position).getDefaultBackground();
            }
        }
    }

    public void checkColor() {
        if (axis == 1) {
            if (classShips != null) {
                if ((classShips.getSize() == 1 | classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                        position > fieldPanelList.size()) {
                    fieldPanelList.get(position).setColorRed();
                } else {
                    if ((classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                            position + 10 >= fieldPanelList.size()) {
                        fieldPanelList.get(position).setColorRed();
                    } else {
                        if ((classShips.getSize() == 3 | classShips.getSize() == 4) &
                                position + 20 >= fieldPanelList.size()) {
                            fieldPanelList.get(position).setColorRed();
                            fieldPanelList.get(position + 10).setColorRed();
                        } else {
                            if (classShips.getSize() == 4 &
                                    position + 30 >= fieldPanelList.size()) {
                                fieldPanelList.get(position).setColorRed();
                                fieldPanelList.get(position + 10).setColorRed();
                                fieldPanelList.get(position + 20).setColorRed();
                            }
                        }
                    }
                }
            }
        }


        if (axis == 0) {
            if (classShips != null) {
                if ((position == 99 | position + 1 == 99 | position + 2 == 99) & classShips.getSize() >= 2)  {
                    if (position + 1 > 99) {
                        fieldPanelList.get(position).setColorRed();
                    } else {
                        if (position + 2 > 99) {
                            fieldPanelList.get(position).setColorRed();
                            fieldPanelList.get(position + 1).setColorRed();
                        } else {
                            if (position + 3 > 99) {
                                fieldPanelList.get(position).setColorRed();
                                fieldPanelList.get(position + 1).setColorRed();
                                fieldPanelList.get(position + 2).setColorRed();

                            }
                        }
                    }
            } else {
                    if ((classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                            position + 1 < fieldPanelList.size()) {
                        if ((position + 1 == 10 || position + 1 == 20 || position + 1 == 30 || position + 1 == 40 || position + 1 == 50 || position + 1 == 60 ||
                                position + 1 == 70 || position + 1 == 80 || position + 1 == 90) | position + 1 > 99) {
                            fieldPanelList.get(position).setColorRed();
                        } else {
                            if ((classShips.getSize() == 3 | classShips.getSize() == 4) |
                                    position + 2 < fieldPanelList.size()) {
                                if ((position + 2 == 10 || position + 2 == 20 || position + 2 == 30 || position + 2 == 40 || position + 2 == 50 || position + 2 == 60 ||
                                        position + 2 == 70 || position + 2 == 80 || position + 2 == 90) | position + 2 > 99) {
                                    fieldPanelList.get(position).setColorRed();
                                    fieldPanelList.get(position + 1).setColorRed();
                                    fieldPanelList.get(position + 2).setColorRed();
                                } else {
                                    if (classShips.getSize() == 4 & position + 3 < fieldPanelList.size()) {
                                        if ((position + 3 == 10 || position + 3 == 20 || position + 3 == 30 || position + 3 == 40 || position + 3 == 50 || position + 3 == 60 ||
                                                position + 3 == 70 || position + 3 == 80 || position + 3 == 90) | position + 3 > 99) {
                                            fieldPanelList.get(position).setColorRed();
                                            fieldPanelList.get(position + 1).setColorRed();
                                            fieldPanelList.get(position + 2).setColorRed();
                                            fieldPanelList.get(position + 3).setColorRed();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Ships getClassShips() {
        return classShips;
    }

    public void setClassShips(Ships classShips) {
        this.classShips = classShips;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setAxis(int axis) {
        this.axis = axis;
    }

    public int getAxis() {
        return axis;
    }
}
