package aoc2020;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day12Part02 extends AdventOfCode {

    public static int solve() {
        List<String> instructions = getData(FileConstants.AOC_2020_12);
        int[] ship = { 0, 0 };
        int[] waypoint = { 1, 10 };
        for (String instruction : instructions) {
            char action = instruction.charAt(0);
            int value = Integer.parseInt(instruction.substring(1));
            int distNS = getDist(waypoint[0], ship[0]);
            int distEW = getDist(waypoint[1], ship[1]);
            switch (action) {
            case 'N':
                waypoint[0] += value;
                break;
            case 'S':
                waypoint[0] -= value;
                break;
            case 'E':
                waypoint[1] += value;
                break;
            case 'W':
                waypoint[1] -= value;
                break;
            case 'L':
                switch (value) {
                case 90:
                    if (waypoint[0] >= ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] + distEW;
                            waypoint[1] = ship[1] - distNS;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] - distEW;
                            waypoint[1] = ship[1] - distNS;
                        }
                    } else if (waypoint[0] < ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] + distEW;
                            waypoint[1] = ship[1] + distNS;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] - distEW;
                            waypoint[1] = ship[1] + distNS;
                        }
                    }
                    break;
                case 180:
                    if (waypoint[0] >= ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] - distNS;
                            waypoint[1] = ship[1] - distEW;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] - distNS;
                            waypoint[1] = ship[1] + distEW;
                        }
                    } else if (waypoint[0] < ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] + distNS;
                            waypoint[1] = ship[1] - distEW;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] + distNS;
                            waypoint[1] = ship[1] + distEW;
                        }
                    }
                    break;
                case 270:
                    if (waypoint[0] >= ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] - distEW;
                            waypoint[1] = ship[1] + distNS;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] + distEW;
                            waypoint[1] = ship[1] + distNS;
                        }
                    } else if (waypoint[0] < ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] - distEW;
                            waypoint[1] = ship[1] - distNS;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] + distEW;
                            waypoint[1] = ship[1] - distNS;
                        }
                    }
                    break;
                default:
                    break;
                }
                break;
            case 'R':
                switch (value) {
                case 90:
                    if (waypoint[0] >= ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] - distEW;
                            waypoint[1] = ship[1] + distNS;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] + distEW;
                            waypoint[1] = ship[1] + distNS;
                        }
                    } else if (waypoint[0] < ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] - distEW;
                            waypoint[1] = ship[1] - distNS;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] + distEW;
                            waypoint[1] = ship[1] - distNS;
                        }
                    }
                    break;
                case 180:
                    if (waypoint[0] >= ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] - distNS;
                            waypoint[1] = ship[1] - distEW;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] - distNS;
                            waypoint[1] = ship[1] + distEW;
                        }
                    } else if (waypoint[0] < ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] + distNS;
                            waypoint[1] = ship[1] - distEW;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] + distNS;
                            waypoint[1] = ship[1] + distEW;
                        }
                    }
                    break;
                case 270:
                    if (waypoint[0] >= ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] + distEW;
                            waypoint[1] = ship[1] - distNS;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] - distEW;
                            waypoint[1] = ship[1] - distNS;
                        }
                    } else if (waypoint[0] < ship[0]) {
                        if (waypoint[1] >= ship[1]) {
                            waypoint[0] = ship[0] + distEW;
                            waypoint[1] = ship[1] + distNS;
                        } else if (waypoint[1] < ship[1]) {
                            waypoint[0] = ship[0] - distEW;
                            waypoint[1] = ship[1] + distNS;
                        }
                    }
                    break;
                default:
                    break;
                }
                break;
            case 'F':
                if (waypoint[0] > ship[0]) {
                    ship[0] += value * distNS;
                    waypoint[0] = ship[0] + distNS;
                } else if (waypoint[0] < ship[0]) {
                    ship[0] -= value * distNS;
                    waypoint[0] = ship[0] - distNS;
                }
                if (waypoint[1] > ship[1]) {
                    ship[1] += value * distEW;
                    waypoint[1] = ship[1] + distEW;
                } else if (waypoint[1] < ship[1]) {
                    ship[1] -= value * distEW;
                    waypoint[1] = ship[1] - distEW;
                }
                break;
            default:
                break;
            }
        }
        return Math.abs(ship[0]) + Math.abs(ship[1]);
    }

    private static int getDist(int waypoint, int ship) {
        if ((waypoint > 0 && ship > 0) || (waypoint < 0 && ship < 0)) {
            return Math.abs(waypoint - ship);
        } else {
            return Math.abs(waypoint) + Math.abs(ship);
        }
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
