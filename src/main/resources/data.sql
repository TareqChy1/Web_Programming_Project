INSERT INTO BUILDING(id, name, address, outside_temperature) VALUES(-10, 'Building 1', 'RUE CHEVREUL', 13.3);
INSERT INTO BUILDING(id, name, address, outside_temperature) VALUES(-9, 'Building 2', 'RUE NOVEMBRE', 14.2);
INSERT INTO BUILDING(id, name, address, outside_temperature) VALUES(-8, 'Building 3', 'SAINT ETIENNE', 18.9);
INSERT INTO BUILDING(id, name, address, outside_temperature) VALUES(-7, 'Building 4', 'RUE TOLBAC', 25.0);
INSERT INTO BUILDING(id, name, address, outside_temperature) VALUES(-6, 'Building 5', 'CLICHY', 18.9);
INSERT INTO BUILDING(id, name, address, outside_temperature) VALUES(-5, 'Building 5', 'ANNIER CLICHY', 19.9);

INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature,building_id) VALUES(-10, 'Room 1', 1, 28.3, 25.0,-10);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-9, 'Room 2', 2, 23.3, 23.0,-8);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-8, 'Room 5', 3, 29.3, 25.0,-8);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(-7, 'Room 6', 1,-9);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(-6, 'Room 7', 2,-7);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(-5, 'Room 8', 3,-7);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(-4, 'Room 9', 2,-6);

INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-10, 'OFF', 'Heater 1', 3400, -8);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-9, 'ON', 'Heater 2', 1500, -7);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-8, 'ON', 'Heater 3', 2400, -7);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-7, 'OFF', 'Heater 4', null, -6);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-6, 'ON', 'Heater 5', 2200, -6);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-5, 'OFF', 'Heater 6', 1300, -4);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-4, 'OFF', 'Heater 7', 2000, -4);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-3, 'ON', 'Heater 8', null, -10);

INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-10, 'CLOSED', 'Window 1', -9);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-9, 'CLOSED', 'Window 2', -8);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-8, 'OPEN', 'Window 3', -9);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-7, 'CLOSED', 'Window 4', -9);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-6, 'CLOSED', 'Window 7', -7);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-3, 'CLOSED', 'Window 8', -8);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-5, 'OPEN', 'Window 9', -7);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-4, 'CLOSED', 'Window 10', -6);