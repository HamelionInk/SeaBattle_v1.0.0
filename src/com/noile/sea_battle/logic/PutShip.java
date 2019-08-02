package com.noile.sea_battle.logic;

import com.noile.sea_battle.logic.ships.Ships;
import com.noile.sea_battle.view.CellPane;

import java.awt.*;
import java.util.ArrayList;

public class PutShip {

    ArrayList<CellPane> fieldPanelList;

    private Ships classShips;
    private int position;
    private int axis;

    public PutShip(ArrayList<CellPane> fieldPanelList) {
        this.fieldPanelList = fieldPanelList;
    }

    public void putShip() {
        if (classShips != null) {
            if (getAxis() == 0) {
                putShipAxisX();
                setClassShips(null);
            }
            if (getAxis() == 1) {
                putShipAxisY();
                setClassShips(null);
            }
        }
    }

    public void putShipAxisX() {
        checkPositionAxisX();
        if ( classShips.getSize() == 1 || classShips.getSize() == 2 || classShips.getSize() == 3 || classShips.getSize() == 4) {
            fieldPanelList.get(position).setCellClassShip();
            fieldPanelList.get(position).reloadStateCell();
            fieldPanelList.get(position).setShipViewIcon();
            if( classShips.getSize() == 2 || classShips.getSize() == 3 || classShips.getSize() == 4) {
                fieldPanelList.get(position + 1).setCellClassShip();
                fieldPanelList.get(position + 1).reloadStateCell();
                fieldPanelList.get(position + 1).setShipViewIcon();
                if ( classShips.getSize() == 3 || classShips.getSize() == 4) {
                    fieldPanelList.get(position + 2).setCellClassShip();
                    fieldPanelList.get(position + 2).reloadStateCell();
                    fieldPanelList.get(position + 2).setShipViewIcon();
                    if( classShips.getSize() == 4) {
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
        checkPositionAxisY();
        if ( classShips.getSize() == 1 || classShips.getSize() == 2 || classShips.getSize() == 3 || classShips.getSize() == 4) {
            fieldPanelList.get(position).setCellClassShip();
            fieldPanelList.get(position).reloadStateCell();
            fieldPanelList.get(position).setShipViewIcon();
            if( classShips.getSize() == 2 || classShips.getSize() == 3 || classShips.getSize() == 4) {
                fieldPanelList.get(position + 10).setCellClassShip();
                fieldPanelList.get(position + 10).reloadStateCell();
                fieldPanelList.get(position + 10).setShipViewIcon();
                if ( classShips.getSize() == 3 || classShips.getSize() == 4) {
                    fieldPanelList.get(position + 20).setCellClassShip();
                    fieldPanelList.get(position + 20).reloadStateCell();
                    fieldPanelList.get(position + 20).setShipViewIcon();
                    if( classShips.getSize() == 4) {
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

    public void checkPositionAxisX() {

    }

    public void checkPositionAxisY() {

    }

    public void entered() {
        if (axis == 1) {
            if (classShips != null) {
                if ((classShips.getSize() == 1 | classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                        position < fieldPanelList.size()) {
                    fieldPanelList.get(position).setDefaultBackground();
                    fieldPanelList.get(position).setBackground(Color.GREEN);
                    if ((classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                            position + 10 < fieldPanelList.size()) {
                        fieldPanelList.get(position + 10).setDefaultBackground();
                        fieldPanelList.get(position + 10).setBackground(Color.GREEN);
                        if ((classShips.getSize() == 3 | classShips.getSize() == 4) &
                                position + 20 < fieldPanelList.size()) {
                            fieldPanelList.get(position + 20).setDefaultBackground();
                            fieldPanelList.get(position + 20).setBackground(Color.GREEN);
                            if (classShips.getSize() == 4 &
                                    position + 30 < fieldPanelList.size()) {
                                fieldPanelList.get(position + 30).setDefaultBackground();
                                fieldPanelList.get(position + 30).setBackground(Color.GREEN);
                            }
                        }
                    }
                }
            }
        } else {
            fieldPanelList.get(position).setDefaultBackground();
            fieldPanelList.get(position).getDefaultBackground();
        }
        if (axis == 0) {
            if (classShips != null) {
                if ((classShips.getSize() == 1 | classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                        position < fieldPanelList.size()) {
                    if (position == 9 || position == 19 || position == 29 || position == 39 || position == 49 || position == 59 ||
                            position == 69 || position == 79 || position == 89 || position == 99) {
                        fieldPanelList.get(position).setDefaultBackground();
                        fieldPanelList.get(position).setBackground(Color.GREEN);
                    } else {
                        fieldPanelList.get(position).setDefaultBackground();
                        fieldPanelList.get(position).setBackground(Color.GREEN);
                        if ((classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                                position + 1 < fieldPanelList.size()) {
                            if (position + 1 == 9 || position + 1 == 19 || position + 1 == 29 || position + 1 == 39 || position + 1 == 49 || position + 1 == 59 ||
                                    position + 1 == 69 || position + 1 == 79 || position + 1 == 89 || position + 1 == 99) {
                                fieldPanelList.get(position + 1).setDefaultBackground();
                                fieldPanelList.get(position + 1).setBackground(Color.GREEN);
                            } else {
                                fieldPanelList.get(position + 1).setDefaultBackground();
                                fieldPanelList.get(position + 1).setBackground(Color.GREEN);
                                if ((classShips.getSize() == 3 | classShips.getSize() == 4) &
                                        position + 2 < fieldPanelList.size()) {
                                    if (position + 2 == 9 || position + 2 == 19 || position + 2 == 29 || position + 2 == 39 || position + 2 == 49 || position + 2 == 59 ||
                                            position + 2 == 69 || position + 2 == 79 || position + 2 == 89 || position + 2 == 99) {
                                        fieldPanelList.get(position + 2).setDefaultBackground();
                                        fieldPanelList.get(position + 2).setBackground(Color.GREEN);
                                    } else {
                                        fieldPanelList.get(position + 2).setDefaultBackground();
                                        fieldPanelList.get(position + 2).setBackground(Color.GREEN);
                                        if (classShips.getSize() == 4 &
                                                position + 3 < fieldPanelList.size()) {
                                            if (position + 3 == 9 || position + 3 == 19 || position + 3 == 29 || position + 3 == 39 || position + 3 == 49 || position + 3 == 59 ||
                                                    position + 3 == 69 || position + 3 == 79 || position + 3 == 89 || position + 3 == 99) {
                                                fieldPanelList.get(position + 3).setDefaultBackground();
                                                fieldPanelList.get(position + 3).setBackground(Color.GREEN);
                                            } else {
                                                fieldPanelList.get(position + 3).setDefaultBackground();
                                                fieldPanelList.get(position + 3).setBackground(Color.GREEN);
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
                fieldPanelList.get(position).getDefaultBackground();
            }
        }
    }

    public void exited() {
        if( axis == 1) {
        if (classShips != null) {
            if ( (classShips.getSize() == 1 | classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                    position < fieldPanelList.size()) {
                fieldPanelList.get(position).getDefaultBackground();
                if ( (classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                        position + 10 < fieldPanelList.size()) {
                    fieldPanelList.get(position + 10).getDefaultBackground();
                    if ( (classShips.getSize() == 3 | classShips.getSize() == 4) &
                            position + 20 < fieldPanelList.size()) {
                        fieldPanelList.get(position + 20).getDefaultBackground();
                        if (classShips.getSize() == 4 &
                                position + 30 < fieldPanelList.size()) {
                            fieldPanelList.get(position + 30).getDefaultBackground();
                        }
                    }
                }
            }
        } else {
            fieldPanelList.get(position).getDefaultBackground();
        }
        }
        if( axis == 0) {
            if (classShips != null) {
                if ( (classShips.getSize() == 1 | classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                        position < fieldPanelList.size()) {
                    fieldPanelList.get(position).getDefaultBackground();
                    if ( (classShips.getSize() == 2 | classShips.getSize() == 3 | classShips.getSize() == 4) &
                            position + 1 < fieldPanelList.size()) {
                        fieldPanelList.get(position + 1).getDefaultBackground();
                        if ( (classShips.getSize() == 3 | classShips.getSize() == 4) &
                                position + 2 < fieldPanelList.size()) {
                            fieldPanelList.get(position + 2).getDefaultBackground();
                            if (classShips.getSize() == 4 &
                                    position + 3 < fieldPanelList.size()) {
                                fieldPanelList.get(position + 3).getDefaultBackground();
                            }
                        }
                    }
                }
            } else {
                fieldPanelList.get(position).getDefaultBackground();
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
