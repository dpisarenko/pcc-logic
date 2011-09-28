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

package at.silverstrike.pcc.gtaskrelevance2;

import at.silverstrike.pcc.api.gtaskrelevance.IsGoogleTaskRelevantCalculatorFactory;
import at.silverstrike.pcc.api.gtaskrelevance2.RelevantTaskSetCalculatorFactory;
import at.silverstrike.pcc.impl.gtaskrelevance.DefaultIsGoogleTaskRelevantCalculatorFactory;
import at.silverstrike.pcc.impl.gtaskrelevance2.DefaultRelevantTaskSetCalculatorFactory;

import com.google.inject.AbstractModule;

/**
 * @author DP118M
 * 
 */
final class MockInjectorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RelevantTaskSetCalculatorFactory.class).toInstance(
                new DefaultRelevantTaskSetCalculatorFactory());
        bind(IsGoogleTaskRelevantCalculatorFactory.class).toInstance(
                new DefaultIsGoogleTaskRelevantCalculatorFactory());
    }

}
