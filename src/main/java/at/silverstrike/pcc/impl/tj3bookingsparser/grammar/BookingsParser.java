// $ANTLR 3.2 Sep 23, 2009 14:05:07 src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g 2012-02-10 16:17:21
 

package at.silverstrike.pcc.impl.tj3bookingsparser.grammar; 

import org.slf4j.Logger;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
public class BookingsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Project", "Prj", "String", "DateTimeWithTimeZone", "Hyphen", "OpenParen", "TimingResolution", "TimingResolutionValue", "TimeZone", "ScenarioPart1", "ScenarioPart2", "CloseParen", "Projectids", "Resource", "Identifier", "Task", "Start", "End", "Scheduling", "SchedulingType", "Scheduled", "Supplement", "Priority", "IntegerNumber", "ProjectIdPrj", "Workinghours", "DayOfWeek", "Off", "Comma", "Time", "Colon", "Booking", "Plus", "FloatingPointNumberDuration", "FloatingPointNumber", "Overtime", "Complete", "D", "P", "H", "A", "Space"
    };
    public static final int End=21;
    public static final int FloatingPointNumberDuration=37;
    public static final int ProjectIdPrj=28;
    public static final int CloseParen=15;
    public static final int Supplement=25;
    public static final int IntegerNumber=27;
    public static final int DayOfWeek=30;
    public static final int DateTimeWithTimeZone=7;
    public static final int EOF=-1;
    public static final int Project=4;
    public static final int FloatingPointNumber=38;
    public static final int Identifier=18;
    public static final int Space=45;
    public static final int Hyphen=8;
    public static final int Overtime=39;
    public static final int OpenParen=9;
    public static final int Booking=35;
    public static final int SchedulingType=23;
    public static final int TimingResolutionValue=11;
    public static final int Projectids=16;
    public static final int Scheduling=22;
    public static final int String=6;
    public static final int Task=19;
    public static final int Complete=40;
    public static final int D=41;
    public static final int Scheduled=24;
    public static final int Start=20;
    public static final int A=44;
    public static final int Prj=5;
    public static final int H=43;
    public static final int Time=33;
    public static final int Colon=34;
    public static final int P=42;
    public static final int TimeZone=12;
    public static final int Resource=17;
    public static final int Plus=36;
    public static final int Off=31;
    public static final int TimingResolution=10;
    public static final int Priority=26;
    public static final int Comma=32;
    public static final int ScenarioPart1=13;
    public static final int Workinghours=29;
    public static final int ScenarioPart2=14;

    // delegates
    // delegators


        public BookingsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BookingsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BookingsParser.tokenNames; }
    public String getGrammarFileName() { return "src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g"; }


    	private DefaultBookingsFile bookingsFile;
    	
    	public DefaultBookingsFile getBookingsFile()
    	{
    		return this.bookingsFile;
    	}




    // $ANTLR start "bookingsFile"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:37:1: bookingsFile : header projectIds resourceDeclaration ( task )+ (suppTask= supplementTask )* ( supplementResource )* EOF ;
    public final void bookingsFile() throws RecognitionException {
        DefaultSupplementStatement suppTask = null;


        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:38:3: ( header projectIds resourceDeclaration ( task )+ (suppTask= supplementTask )* ( supplementResource )* EOF )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:39:2: header projectIds resourceDeclaration ( task )+ (suppTask= supplementTask )* ( supplementResource )* EOF
            {

            		this.bookingsFile = new DefaultBookingsFile();
            	
            pushFollow(FOLLOW_header_in_bookingsFile43);
            header();

            state._fsp--;

            pushFollow(FOLLOW_projectIds_in_bookingsFile47);
            projectIds();

            state._fsp--;

            pushFollow(FOLLOW_resourceDeclaration_in_bookingsFile51);
            resourceDeclaration();

            state._fsp--;

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:45:3: ( task )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Task) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:45:3: task
            	    {
            	    pushFollow(FOLLOW_task_in_bookingsFile55);
            	    task();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:46:3: (suppTask= supplementTask )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Supplement) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==Task) ) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:47:4: suppTask= supplementTask
            	    {
            	    pushFollow(FOLLOW_supplementTask_in_bookingsFile67);
            	    suppTask=supplementTask();

            	    state._fsp--;


            	      		if (suppTask.getTaskId().startsWith("T"))
            	      		{
            	      		  this.bookingsFile.addSupplementStatement( suppTask );
            	      		} 
            	      	

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:55:3: ( supplementResource )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Supplement) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:55:3: supplementResource
            	    {
            	    pushFollow(FOLLOW_supplementResource_in_bookingsFile82);
            	    supplementResource();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_bookingsFile87); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "bookingsFile"


    // $ANTLR start "header"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:59:1: header : Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen ( TimingResolution )* ( TimingResolutionValue )* ( TimeZone )* ( String )* ScenarioPart1 OpenParen ( ScenarioPart2 )* CloseParen CloseParen ;
    public final void header() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:60:2: ( Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen ( TimingResolution )* ( TimingResolutionValue )* ( TimeZone )* ( String )* ScenarioPart1 OpenParen ( ScenarioPart2 )* CloseParen CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:61:2: Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen ( TimingResolution )* ( TimingResolutionValue )* ( TimeZone )* ( String )* ScenarioPart1 OpenParen ( ScenarioPart2 )* CloseParen CloseParen
            {
            match(input,Project,FOLLOW_Project_in_header100); 
            match(input,Prj,FOLLOW_Prj_in_header102); 
            match(input,String,FOLLOW_String_in_header104); 
            match(input,String,FOLLOW_String_in_header106); 
            match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_header108); 
            match(input,Hyphen,FOLLOW_Hyphen_in_header110); 
            match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_header112); 
            match(input,OpenParen,FOLLOW_OpenParen_in_header114); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:61:87: ( TimingResolution )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==TimingResolution) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:61:87: TimingResolution
            	    {
            	    match(input,TimingResolution,FOLLOW_TimingResolution_in_header116); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:61:105: ( TimingResolutionValue )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==TimingResolutionValue) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:61:105: TimingResolutionValue
            	    {
            	    match(input,TimingResolutionValue,FOLLOW_TimingResolutionValue_in_header119); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:61:128: ( TimeZone )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==TimeZone) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:61:128: TimeZone
            	    {
            	    match(input,TimeZone,FOLLOW_TimeZone_in_header122); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:61:138: ( String )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==String) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:61:138: String
            	    {
            	    match(input,String,FOLLOW_String_in_header125); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,ScenarioPart1,FOLLOW_ScenarioPart1_in_header130); 
            match(input,OpenParen,FOLLOW_OpenParen_in_header132); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:62:26: ( ScenarioPart2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==ScenarioPart2) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:62:26: ScenarioPart2
            	    {
            	    match(input,ScenarioPart2,FOLLOW_ScenarioPart2_in_header134); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,CloseParen,FOLLOW_CloseParen_in_header137); 
            match(input,CloseParen,FOLLOW_CloseParen_in_header141); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "header"


    // $ANTLR start "projectIds"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:86:1: projectIds : Projectids Prj ;
    public final void projectIds() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:86:11: ( Projectids Prj )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:87:2: Projectids Prj
            {
            match(input,Projectids,FOLLOW_Projectids_in_projectIds200); 
            match(input,Prj,FOLLOW_Prj_in_projectIds202); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "projectIds"


    // $ANTLR start "resourceDeclaration"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:90:1: resourceDeclaration : Resource Identifier String ;
    public final void resourceDeclaration() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:91:2: ( Resource Identifier String )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:91:4: Resource Identifier String
            {
            match(input,Resource,FOLLOW_Resource_in_resourceDeclaration213); 
            match(input,Identifier,FOLLOW_Identifier_in_resourceDeclaration215); 
            match(input,String,FOLLOW_String_in_resourceDeclaration217); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "resourceDeclaration"


    // $ANTLR start "task"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:94:1: task : Task Identifier String OpenParen ( task )* ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling SchedulingType Scheduled )* CloseParen ;
    public final void task() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:95:2: ( Task Identifier String OpenParen ( task )* ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling SchedulingType Scheduled )* CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:96:2: Task Identifier String OpenParen ( task )* ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling SchedulingType Scheduled )* CloseParen
            {
            match(input,Task,FOLLOW_Task_in_task229); 
            match(input,Identifier,FOLLOW_Identifier_in_task231); 
            match(input,String,FOLLOW_String_in_task233); 
            match(input,OpenParen,FOLLOW_OpenParen_in_task235); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:97:2: ( task )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Task) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:97:3: task
            	    {
            	    pushFollow(FOLLOW_task_in_task239);
            	    task();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:98:2: ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling SchedulingType Scheduled )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Start) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:98:3: Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling SchedulingType Scheduled
            	    {
            	    match(input,Start,FOLLOW_Start_in_task246); 
            	    match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_task248); 
            	    match(input,End,FOLLOW_End_in_task251); 
            	    match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_task253); 
            	    match(input,Scheduling,FOLLOW_Scheduling_in_task256); 
            	    match(input,SchedulingType,FOLLOW_SchedulingType_in_task258); 
            	    match(input,Scheduled,FOLLOW_Scheduled_in_task261); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match(input,CloseParen,FOLLOW_CloseParen_in_task266); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "task"


    // $ANTLR start "supplementTask"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:105:1: supplementTask returns [DefaultSupplementStatement suppStmt] : Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber ProjectIdPrj CloseParen ;
    public final DefaultSupplementStatement supplementTask() throws RecognitionException {
        DefaultSupplementStatement suppStmt = null;

        Token taskId=null;
        DefaultBookingStatement bStmt = null;


        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:106:2: ( Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber ProjectIdPrj CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:107:3: Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber ProjectIdPrj CloseParen
            {

            			suppStmt = new DefaultSupplementStatement();
            		
            match(input,Supplement,FOLLOW_Supplement_in_supplementTask287); 
            match(input,Task,FOLLOW_Task_in_supplementTask289); 
            taskId=(Token)match(input,Identifier,FOLLOW_Identifier_in_supplementTask293); 
            suppStmt.setTaskId((taskId!=null?taskId.getText():null)); 
            match(input,OpenParen,FOLLOW_OpenParen_in_supplementTask299); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:112:2: (bStmt= booking )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Booking) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:113:2: bStmt= booking
            	    {
            	    pushFollow(FOLLOW_booking_in_supplementTask307);
            	    bStmt=booking();

            	    state._fsp--;

            	    suppStmt.addBookingStatement( bStmt ); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match(input,Priority,FOLLOW_Priority_in_supplementTask317); 
            match(input,IntegerNumber,FOLLOW_IntegerNumber_in_supplementTask319); 
            match(input,ProjectIdPrj,FOLLOW_ProjectIdPrj_in_supplementTask322); 
            match(input,CloseParen,FOLLOW_CloseParen_in_supplementTask325); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return suppStmt;
    }
    // $ANTLR end "supplementTask"


    // $ANTLR start "supplementResource"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:120:1: supplementResource : Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen ;
    public final void supplementResource() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:121:2: ( Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:122:2: Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen
            {
            match(input,Supplement,FOLLOW_Supplement_in_supplementResource337); 
            match(input,Resource,FOLLOW_Resource_in_supplementResource339); 
            match(input,Identifier,FOLLOW_Identifier_in_supplementResource341); 
            match(input,OpenParen,FOLLOW_OpenParen_in_supplementResource343); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:123:2: ( workinghours )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==Workinghours) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:123:2: workinghours
            	    {
            	    pushFollow(FOLLOW_workinghours_in_supplementResource346);
            	    workinghours();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            match(input,CloseParen,FOLLOW_CloseParen_in_supplementResource350); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "supplementResource"


    // $ANTLR start "workinghours"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:127:1: workinghours : Workinghours DayOfWeek ( Off | workingIntervals ) ;
    public final void workinghours() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:128:2: ( Workinghours DayOfWeek ( Off | workingIntervals ) )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:129:2: Workinghours DayOfWeek ( Off | workingIntervals )
            {
            match(input,Workinghours,FOLLOW_Workinghours_in_workinghours362); 
            match(input,DayOfWeek,FOLLOW_DayOfWeek_in_workinghours364); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:129:25: ( Off | workingIntervals )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Off) ) {
                alt13=1;
            }
            else if ( (LA13_0==Time) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:129:26: Off
                    {
                    match(input,Off,FOLLOW_Off_in_workinghours367); 

                    }
                    break;
                case 2 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:129:30: workingIntervals
                    {
                    pushFollow(FOLLOW_workingIntervals_in_workinghours369);
                    workingIntervals();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "workinghours"


    // $ANTLR start "workingIntervals"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:136:1: workingIntervals : workingInterval ( Comma workingInterval )* ;
    public final void workingIntervals() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:137:2: ( workingInterval ( Comma workingInterval )* )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:138:2: workingInterval ( Comma workingInterval )*
            {
            pushFollow(FOLLOW_workingInterval_in_workingIntervals393);
            workingInterval();

            state._fsp--;

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:138:18: ( Comma workingInterval )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==Comma) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:138:19: Comma workingInterval
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_workingIntervals396); 
            	    pushFollow(FOLLOW_workingInterval_in_workingIntervals398);
            	    workingInterval();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "workingIntervals"


    // $ANTLR start "workingInterval"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:141:1: workingInterval : Time Hyphen Time ;
    public final void workingInterval() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:142:2: ( Time Hyphen Time )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:142:4: Time Hyphen Time
            {
            match(input,Time,FOLLOW_Time_in_workingInterval412); 
            match(input,Hyphen,FOLLOW_Hyphen_in_workingInterval414); 
            match(input,Time,FOLLOW_Time_in_workingInterval416); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "workingInterval"


    // $ANTLR start "booking"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:174:1: booking returns [DefaultBookingStatement stmt] : Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen ) ;
    public final DefaultBookingStatement booking() throws RecognitionException {
        DefaultBookingStatement stmt = null;

        Token resource=null;
        DefaultIndBooking bt1 = null;

        DefaultIndBooking bt2 = null;


        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:175:2: ( Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen ) )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:176:2: Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen )
            {

            		stmt = new DefaultBookingStatement();
            	
            match(input,Booking,FOLLOW_Booking_in_booking530); 
            resource=(Token)match(input,Identifier,FOLLOW_Identifier_in_booking534); 
             stmt.setResource((resource!=null?resource.getText():null)); 
            pushFollow(FOLLOW_bookingTime_in_booking543);
            bt1=bookingTime();

            state._fsp--;

             stmt.addIndBooking(bt1); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:181:2: ( Comma bt2= bookingTime )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==Comma) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:181:3: Comma bt2= bookingTime
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_booking550); 
            	    pushFollow(FOLLOW_bookingTime_in_booking556);
            	    bt2=bookingTime();

            	    state._fsp--;

            	     stmt.addIndBooking(bt2); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:184:2: ( OpenParen overtime CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:184:3: OpenParen overtime CloseParen
            {
            match(input,OpenParen,FOLLOW_OpenParen_in_booking568); 
            pushFollow(FOLLOW_overtime_in_booking572);
            overtime();

            state._fsp--;

            match(input,CloseParen,FOLLOW_CloseParen_in_booking576); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "booking"


    // $ANTLR start "bookingTime"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:189:1: bookingTime returns [DefaultIndBooking indBooking] : startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration ;
    public final DefaultIndBooking bookingTime() throws RecognitionException {
        DefaultIndBooking indBooking = null;

        Token startTime=null;
        Token bookingDuration=null;

        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:190:2: (startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:191:2: startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration
            {
            startTime=(Token)match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_bookingTime595); 
            match(input,Plus,FOLLOW_Plus_in_bookingTime599); 
            bookingDuration=(Token)match(input,FloatingPointNumberDuration,FOLLOW_FloatingPointNumberDuration_in_bookingTime605); 

            		indBooking = new DefaultIndBooking((startTime!=null?startTime.getText():null), (bookingDuration!=null?bookingDuration.getText():null));
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return indBooking;
    }
    // $ANTLR end "bookingTime"


    // $ANTLR start "duration"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:214:1: duration : FloatingPointNumber 'h' ;
    public final void duration() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:215:2: ( FloatingPointNumber 'h' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:216:2: FloatingPointNumber 'h'
            {
            match(input,FloatingPointNumber,FOLLOW_FloatingPointNumber_in_duration657); 
            match(input,H,FOLLOW_H_in_duration659); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "duration"


    // $ANTLR start "overtime"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:219:1: overtime : Overtime IntegerNumber ;
    public final void overtime() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:220:2: ( Overtime IntegerNumber )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:221:2: Overtime IntegerNumber
            {
            match(input,Overtime,FOLLOW_Overtime_in_overtime671); 
            match(input,IntegerNumber,FOLLOW_IntegerNumber_in_overtime673); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "overtime"

    // Delegated rules


 

    public static final BitSet FOLLOW_header_in_bookingsFile43 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_projectIds_in_bookingsFile47 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_resourceDeclaration_in_bookingsFile51 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_task_in_bookingsFile55 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_supplementTask_in_bookingsFile67 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_supplementResource_in_bookingsFile82 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_EOF_in_bookingsFile87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Project_in_header100 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Prj_in_header102 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_header104 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_header106 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_header108 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Hyphen_in_header110 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_header112 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_header114 = new BitSet(new long[]{0x0000000000003C40L});
    public static final BitSet FOLLOW_TimingResolution_in_header116 = new BitSet(new long[]{0x0000000000003C40L});
    public static final BitSet FOLLOW_TimingResolutionValue_in_header119 = new BitSet(new long[]{0x0000000000003840L});
    public static final BitSet FOLLOW_TimeZone_in_header122 = new BitSet(new long[]{0x0000000000003040L});
    public static final BitSet FOLLOW_String_in_header125 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_ScenarioPart1_in_header130 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_header132 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_ScenarioPart2_in_header134 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_CloseParen_in_header137 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CloseParen_in_header141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Projectids_in_projectIds200 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Prj_in_projectIds202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Resource_in_resourceDeclaration213 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_Identifier_in_resourceDeclaration215 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_resourceDeclaration217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Task_in_task229 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_Identifier_in_task231 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_task233 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_task235 = new BitSet(new long[]{0x0000000000188000L});
    public static final BitSet FOLLOW_task_in_task239 = new BitSet(new long[]{0x0000000000188000L});
    public static final BitSet FOLLOW_Start_in_task246 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_task248 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_End_in_task251 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_task253 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Scheduling_in_task256 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SchedulingType_in_task258 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Scheduled_in_task261 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_CloseParen_in_task266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Supplement_in_supplementTask287 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_Task_in_supplementTask289 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_Identifier_in_supplementTask293 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_supplementTask299 = new BitSet(new long[]{0x0000000804000000L});
    public static final BitSet FOLLOW_booking_in_supplementTask307 = new BitSet(new long[]{0x0000000804000000L});
    public static final BitSet FOLLOW_Priority_in_supplementTask317 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_IntegerNumber_in_supplementTask319 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ProjectIdPrj_in_supplementTask322 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CloseParen_in_supplementTask325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Supplement_in_supplementResource337 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_Resource_in_supplementResource339 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_Identifier_in_supplementResource341 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_supplementResource343 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_workinghours_in_supplementResource346 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_CloseParen_in_supplementResource350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Workinghours_in_workinghours362 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_DayOfWeek_in_workinghours364 = new BitSet(new long[]{0x0000000280000000L});
    public static final BitSet FOLLOW_Off_in_workinghours367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_workingIntervals_in_workinghours369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_workingInterval_in_workingIntervals393 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_Comma_in_workingIntervals396 = new BitSet(new long[]{0x0000000280000000L});
    public static final BitSet FOLLOW_workingInterval_in_workingIntervals398 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_Time_in_workingInterval412 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Hyphen_in_workingInterval414 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Time_in_workingInterval416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Booking_in_booking530 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_Identifier_in_booking534 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bookingTime_in_booking543 = new BitSet(new long[]{0x0000000100000200L});
    public static final BitSet FOLLOW_Comma_in_booking550 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bookingTime_in_booking556 = new BitSet(new long[]{0x0000000100000200L});
    public static final BitSet FOLLOW_OpenParen_in_booking568 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_overtime_in_booking572 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CloseParen_in_booking576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_bookingTime595 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_Plus_in_bookingTime599 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_FloatingPointNumberDuration_in_bookingTime605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloatingPointNumber_in_duration657 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_H_in_duration659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Overtime_in_overtime671 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_IntegerNumber_in_overtime673 = new BitSet(new long[]{0x0000000000000002L});

}