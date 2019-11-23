package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorObjectAdapter implements Door {

    private ThirdPartyDoor door;

    public ThirdPartyDoorObjectAdapter() {
        this.door = new ThirdPartyDoor();
    }


    @Override
    public void open(String code) throws IncorrectDoorCodeException {

        try{
            door.unlock(code);
            door.setState(ThirdPartyDoor.DoorState.OPEN);
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException();
        } catch (CannotChangeStateOfLockedDoor cannotChangeStateOfLockedDoor) {
            cannotChangeStateOfLockedDoor.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            door.setState(ThirdPartyDoor.DoorState.CLOSED);
        } catch (CannotChangeStateOfLockedDoor cannotChangeStateOfLockedDoor) {
            cannotChangeStateOfLockedDoor.printStackTrace();
        }
    }

    @Override
    public boolean isOpen() {
        return ThirdPartyDoor.DoorState.OPEN == door.getState();
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {

        try {
            door.unlock(oldCode);
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException();
        }

        if(newCode == newCodeConfirmation){
            try {
                door.setNewLockCode(newCode);
            } catch (CannotChangeCodeForUnlockedDoor cannotChangeCodeForUnlockedDoor) {
                cannotChangeCodeForUnlockedDoor.printStackTrace();
            }
        }
        else
            throw new CodeMismatchException();

    }

    @Override
    public boolean testCode(String code) {
        ThirdPartyDoor.DoorState previousState = door.getState();

        try {
            door.unlock(code);
        } catch (CannotUnlockDoorException e) {
            return false;
        }

        if(door.getState() != previousState) {
            try {
                door.setState(previousState);
            } catch (CannotChangeStateOfLockedDoor cannotChangeStateOfLockedDoor) {
                cannotChangeStateOfLockedDoor.printStackTrace();
            }
        }

        return true;

    }
}