/**
 * This file is part of Project Control Center (PCC).
 * 
 * PCC (Project Control Center) project is intellectual property of 
 * Dmitri Anatol'evich Pisarenko.
 * 
 * Copyright 2010, 2011 Dmitri Anatol'evich Pisarenko
 * All rights reserved
 *
 **/

package at.silverstrike.pcc.gcaltasks2pccimporter;

import at.silverstrike.pcc.api.model.Task;
import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.impl.mockpersistence.MockObjectFactory;
import at.silverstrike.pcc.impl.mockpersistence.MockPersistenceAdapter;

/**
 * @author DP118M
 *
 */
final class MockPersistence extends MockPersistenceAdapter {
    private static MockObjectFactory MOCK_OBJECT_FACTORY = new MockObjectFactory();
    
    @Override
    public Task createTransientTask(String aProcessName, Long aParentProcessId,
            UserData aUser, final long aTaskId) {
        final Task task = MOCK_OBJECT_FACTORY.createTask();
        
        task.setName(aProcessName);
        task.setUserData(aUser);
        
        return task;
    }

}
