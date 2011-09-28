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

package at.silverstrike.pcc.impl.gtaskrelevance2;

import at.silverstrike.pcc.api.gtaskrelevance2.RelevantTaskSetCalculator;
import at.silverstrike.pcc.api.gtaskrelevance2.RelevantTaskSetCalculatorFactory;

/**
 * @author DP118M
 *
 */
public final class DefaultRelevantTaskSetCalculatorFactory implements
        RelevantTaskSetCalculatorFactory {

    @Override
    public RelevantTaskSetCalculator create() {
        return new DefaultRelevantTaskSetCalculator();
    }

}
