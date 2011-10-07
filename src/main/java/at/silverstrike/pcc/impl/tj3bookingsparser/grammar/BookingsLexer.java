// $ANTLR 3.2 Sep 23, 2009 14:05:07 src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g 2011-10-07 19:07:54

package at.silverstrike.pcc.impl.tj3bookingsparser.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BookingsLexer extends Lexer {
    public static final int End=19;
    public static final int FloatingPointNumberDuration=35;
    public static final int ProjectIdPrj=26;
    public static final int CloseParen=13;
    public static final int IntegerNumber=25;
    public static final int Supplement=23;
    public static final int DayOfWeek=28;
    public static final int DateTimeWithTimeZone=7;
    public static final int EOF=-1;
    public static final int FloatingPointNumber=36;
    public static final int Project=4;
    public static final int Identifier=16;
    public static final int Space=43;
    public static final int Hyphen=8;
    public static final int Overtime=37;
    public static final int OpenParen=9;
    public static final int Booking=33;
    public static final int SchedulingType=21;
    public static final int Projectids=14;
    public static final int Scheduling=20;
    public static final int String=6;
    public static final int Task=17;
    public static final int Complete=38;
    public static final int D=39;
    public static final int Scheduled=22;
    public static final int Start=18;
    public static final int A=42;
    public static final int Prj=5;
    public static final int H=41;
    public static final int Time=31;
    public static final int Colon=32;
    public static final int P=40;
    public static final int TimeZone=10;
    public static final int Resource=15;
    public static final int Plus=34;
    public static final int Off=29;
    public static final int Priority=24;
    public static final int Comma=30;
    public static final int ScenarioPart1=11;
    public static final int Workinghours=27;
    public static final int ScenarioPart2=12;

    // delegates
    // delegators

    public BookingsLexer() {;} 
    public BookingsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BookingsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g"; }

    // $ANTLR start "ScenarioPart1"
    public final void mScenarioPart1() throws RecognitionException {
        try {
            int _type = ScenarioPart1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:67:2: ( 'scenario plan \"Plan\"' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:68:2: 'scenario plan \"Plan\"'
            {
            match("scenario plan \"Plan\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ScenarioPart1"

    // $ANTLR start "ScenarioPart2"
    public final void mScenarioPart2() throws RecognitionException {
        try {
            int _type = ScenarioPart2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:72:2: ( 'active yes' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:73:2: 'active yes'
            {
            match("active yes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ScenarioPart2"

    // $ANTLR start "TimeZone"
    public final void mTimeZone() throws RecognitionException {
        try {
            int _type = TimeZone;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:77:2: ( 'timezone' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:78:2: 'timezone'
            {
            match("timezone"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TimeZone"

    // $ANTLR start "Workinghours"
    public final void mWorkinghours() throws RecognitionException {
        try {
            int _type = Workinghours;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:128:2: ( 'workinghours' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:128:4: 'workinghours'
            {
            match("workinghours"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Workinghours"

    // $ANTLR start "Time"
    public final void mTime() throws RecognitionException {
        try {
            int _type = Time;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:141:2: ( IntegerNumber Colon IntegerNumber )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:141:4: IntegerNumber Colon IntegerNumber
            {
            mIntegerNumber(); 
            mColon(); 
            mIntegerNumber(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Time"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:145:2: ( ':' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:146:2: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:150:2: ( ',' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:151:2: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "DayOfWeek"
    public final void mDayOfWeek() throws RecognitionException {
        try {
            int _type = DayOfWeek;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:155:2: ( 'mon' | 'tue' | 'wed' | 'thu' | 'fri' | 'sat' | 'sun' )
            int alt1=7;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:155:4: 'mon'
                    {
                    match("mon"); 


                    }
                    break;
                case 2 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:156:4: 'tue'
                    {
                    match("tue"); 


                    }
                    break;
                case 3 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:157:4: 'wed'
                    {
                    match("wed"); 


                    }
                    break;
                case 4 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:158:4: 'thu'
                    {
                    match("thu"); 


                    }
                    break;
                case 5 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:159:4: 'fri'
                    {
                    match("fri"); 


                    }
                    break;
                case 6 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:160:4: 'sat'
                    {
                    match("sat"); 


                    }
                    break;
                case 7 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:161:4: 'sun'
                    {
                    match("sun"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DayOfWeek"

    // $ANTLR start "Off"
    public final void mOff() throws RecognitionException {
        try {
            int _type = Off;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:165:2: ( 'off' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:166:2: 'off'
            {
            match("off"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Off"

    // $ANTLR start "ProjectIdPrj"
    public final void mProjectIdPrj() throws RecognitionException {
        try {
            int _type = ProjectIdPrj;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:195:2: ( 'projectid prj' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:196:2: 'projectid prj'
            {
            match("projectid prj"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ProjectIdPrj"

    // $ANTLR start "Booking"
    public final void mBooking() throws RecognitionException {
        try {
            int _type = Booking;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:200:2: ( 'booking' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:201:2: 'booking'
            {
            match("booking"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Booking"

    // $ANTLR start "Plus"
    public final void mPlus() throws RecognitionException {
        try {
            int _type = Plus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:205:2: ( '+' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:206:2: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Plus"

    // $ANTLR start "Overtime"
    public final void mOvertime() throws RecognitionException {
        try {
            int _type = Overtime;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:220:2: ( 'overtime' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:221:2: 'overtime'
            {
            match("overtime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Overtime"

    // $ANTLR start "Supplement"
    public final void mSupplement() throws RecognitionException {
        try {
            int _type = Supplement;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:225:2: ( 'supplement' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:226:2: 'supplement'
            {
            match("supplement"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Supplement"

    // $ANTLR start "Priority"
    public final void mPriority() throws RecognitionException {
        try {
            int _type = Priority;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:230:2: ( 'priority' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:231:2: 'priority'
            {
            match("priority"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Priority"

    // $ANTLR start "Complete"
    public final void mComplete() throws RecognitionException {
        try {
            int _type = Complete;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:235:2: ( 'complete' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:236:2: 'complete'
            {
            match("complete"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Complete"

    // $ANTLR start "Start"
    public final void mStart() throws RecognitionException {
        try {
            int _type = Start;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:240:2: ( 'start' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:241:2: 'start'
            {
            match("start"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Start"

    // $ANTLR start "End"
    public final void mEnd() throws RecognitionException {
        try {
            int _type = End;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:245:2: ( 'end' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:246:2: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "End"

    // $ANTLR start "Scheduling"
    public final void mScheduling() throws RecognitionException {
        try {
            int _type = Scheduling;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:250:2: ( 'scheduling' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:251:2: 'scheduling'
            {
            match("scheduling"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Scheduling"

    // $ANTLR start "SchedulingType"
    public final void mSchedulingType() throws RecognitionException {
        try {
            int _type = SchedulingType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:256:2: ( 'asap' | 'alap' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='a') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='s') ) {
                    alt2=1;
                }
                else if ( (LA2_1=='l') ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:256:4: 'asap'
                    {
                    match("asap"); 


                    }
                    break;
                case 2 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:257:4: 'alap'
                    {
                    match("alap"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SchedulingType"

    // $ANTLR start "Scheduled"
    public final void mScheduled() throws RecognitionException {
        try {
            int _type = Scheduled;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:261:2: ( 'scheduled' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:262:2: 'scheduled'
            {
            match("scheduled"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Scheduled"

    // $ANTLR start "Task"
    public final void mTask() throws RecognitionException {
        try {
            int _type = Task;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:266:2: ( 'task' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:267:2: 'task'
            {
            match("task"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Task"

    // $ANTLR start "Resource"
    public final void mResource() throws RecognitionException {
        try {
            int _type = Resource;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:271:2: ( 'resource' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:272:2: 'resource'
            {
            match("resource"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Resource"

    // $ANTLR start "Projectids"
    public final void mProjectids() throws RecognitionException {
        try {
            int _type = Projectids;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:276:2: ( 'projectids' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:277:2: 'projectids'
            {
            match("projectids"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Projectids"

    // $ANTLR start "Project"
    public final void mProject() throws RecognitionException {
        try {
            int _type = Project;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:281:3: ( 'project' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:281:6: 'project'
            {
            match("project"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Project"

    // $ANTLR start "Prj"
    public final void mPrj() throws RecognitionException {
        try {
            int _type = Prj;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:285:3: ( 'prj' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:285:6: 'prj'
            {
            match("prj"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Prj"

    // $ANTLR start "OpenParen"
    public final void mOpenParen() throws RecognitionException {
        try {
            int _type = OpenParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:289:3: ( '{' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:289:6: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OpenParen"

    // $ANTLR start "CloseParen"
    public final void mCloseParen() throws RecognitionException {
        try {
            int _type = CloseParen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:293:3: ( '}' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:293:6: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CloseParen"

    // $ANTLR start "Hyphen"
    public final void mHyphen() throws RecognitionException {
        try {
            int _type = Hyphen;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:297:3: ( '-' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:297:6: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Hyphen"

    // $ANTLR start "FloatingPointNumber"
    public final void mFloatingPointNumber() throws RecognitionException {
        try {
            int _type = FloatingPointNumber;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:301:3: ( ( D )+ '.' ( D )+ )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:301:5: ( D )+ '.' ( D )+
            {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:301:5: ( D )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:301:5: D
            	    {
            	    mD(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            match('.'); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:301:10: ( D )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:301:10: D
            	    {
            	    mD(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FloatingPointNumber"

    // $ANTLR start "FloatingPointNumberDuration"
    public final void mFloatingPointNumberDuration() throws RecognitionException {
        try {
            int _type = FloatingPointNumberDuration;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:304:3: ( ( D )+ P ( D )+ H )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:304:5: ( D )+ P ( D )+ H
            {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:304:5: ( D )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:304:5: D
            	    {
            	    mD(); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            mP(); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:304:10: ( D )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:304:10: D
            	    {
            	    mD(); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            mH(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FloatingPointNumberDuration"

    // $ANTLR start "IntegerNumber"
    public final void mIntegerNumber() throws RecognitionException {
        try {
            int _type = IntegerNumber;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:308:3: ( ( D )+ )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:308:5: ( D )+
            {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:308:5: ( D )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:308:5: D
            	    {
            	    mD(); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IntegerNumber"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:312:3: ( ( D | A | P )+ )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:312:5: ( D | A | P )+
            {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:312:5: ( D | A | P )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='.'||(LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Identifier"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:315:3: ( '\"' (~ '\"' )* '\"' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:315:6: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:315:10: (~ '\"' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:315:10: ~ '\"'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "DateTimeWithTimeZone"
    public final void mDateTimeWithTimeZone() throws RecognitionException {
        try {
            int _type = DateTimeWithTimeZone;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:319:3: ( D D D D '-' D D '-' D D '-' D D ':' D D '-+' D D D D )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:319:6: D D D D '-' D D '-' D D '-' D D ':' D D '-+' D D D D
            {
            mD(); 
            mD(); 
            mD(); 
            mD(); 
            match('-'); 
            mD(); 
            mD(); 
            match('-'); 
            mD(); 
            mD(); 
            match('-'); 
            mD(); 
            mD(); 
            match(':'); 
            mD(); 
            mD(); 
            match("-+"); 

            mD(); 
            mD(); 
            mD(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DateTimeWithTimeZone"

    // $ANTLR start "D"
    public final void mD() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:324:3: ( '0' .. '9' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:324:6: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "D"

    // $ANTLR start "A"
    public final void mA() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:329:3: ( 'A' .. 'Z' | 'a' .. 'z' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "A"

    // $ANTLR start "P"
    public final void mP() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:335:3: ( '.' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:335:5: '.'
            {
            match('.'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "P"

    // $ANTLR start "H"
    public final void mH() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:340:3: ( 'h' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:340:5: 'h'
            {
            match('h'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "H"

    // $ANTLR start "Space"
    public final void mSpace() throws RecognitionException {
        try {
            int _type = Space;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:345:3: ( ( ' ' | '\\t' | ( '\\r' )? '\\n' ) )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:345:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )
            {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:345:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )
            int alt11=3;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt11=1;
                }
                break;
            case '\t':
                {
                alt11=2;
                }
                break;
            case '\n':
            case '\r':
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:345:7: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:345:13: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 3 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:345:20: ( '\\r' )? '\\n'
                    {
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:345:20: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:345:20: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Space"

    public void mTokens() throws RecognitionException {
        // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:8: ( ScenarioPart1 | ScenarioPart2 | TimeZone | Workinghours | Time | Colon | Comma | DayOfWeek | Off | ProjectIdPrj | Booking | Plus | Overtime | Supplement | Priority | Complete | Start | End | Scheduling | SchedulingType | Scheduled | Task | Resource | Projectids | Project | Prj | OpenParen | CloseParen | Hyphen | FloatingPointNumber | FloatingPointNumberDuration | IntegerNumber | Identifier | String | DateTimeWithTimeZone | Space )
        int alt12=36;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:10: ScenarioPart1
                {
                mScenarioPart1(); 

                }
                break;
            case 2 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:24: ScenarioPart2
                {
                mScenarioPart2(); 

                }
                break;
            case 3 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:38: TimeZone
                {
                mTimeZone(); 

                }
                break;
            case 4 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:47: Workinghours
                {
                mWorkinghours(); 

                }
                break;
            case 5 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:60: Time
                {
                mTime(); 

                }
                break;
            case 6 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:65: Colon
                {
                mColon(); 

                }
                break;
            case 7 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:71: Comma
                {
                mComma(); 

                }
                break;
            case 8 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:77: DayOfWeek
                {
                mDayOfWeek(); 

                }
                break;
            case 9 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:87: Off
                {
                mOff(); 

                }
                break;
            case 10 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:91: ProjectIdPrj
                {
                mProjectIdPrj(); 

                }
                break;
            case 11 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:104: Booking
                {
                mBooking(); 

                }
                break;
            case 12 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:112: Plus
                {
                mPlus(); 

                }
                break;
            case 13 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:117: Overtime
                {
                mOvertime(); 

                }
                break;
            case 14 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:126: Supplement
                {
                mSupplement(); 

                }
                break;
            case 15 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:137: Priority
                {
                mPriority(); 

                }
                break;
            case 16 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:146: Complete
                {
                mComplete(); 

                }
                break;
            case 17 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:155: Start
                {
                mStart(); 

                }
                break;
            case 18 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:161: End
                {
                mEnd(); 

                }
                break;
            case 19 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:165: Scheduling
                {
                mScheduling(); 

                }
                break;
            case 20 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:176: SchedulingType
                {
                mSchedulingType(); 

                }
                break;
            case 21 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:191: Scheduled
                {
                mScheduled(); 

                }
                break;
            case 22 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:201: Task
                {
                mTask(); 

                }
                break;
            case 23 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:206: Resource
                {
                mResource(); 

                }
                break;
            case 24 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:215: Projectids
                {
                mProjectids(); 

                }
                break;
            case 25 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:226: Project
                {
                mProject(); 

                }
                break;
            case 26 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:234: Prj
                {
                mPrj(); 

                }
                break;
            case 27 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:238: OpenParen
                {
                mOpenParen(); 

                }
                break;
            case 28 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:248: CloseParen
                {
                mCloseParen(); 

                }
                break;
            case 29 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:259: Hyphen
                {
                mHyphen(); 

                }
                break;
            case 30 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:266: FloatingPointNumber
                {
                mFloatingPointNumber(); 

                }
                break;
            case 31 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:286: FloatingPointNumberDuration
                {
                mFloatingPointNumberDuration(); 

                }
                break;
            case 32 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:314: IntegerNumber
                {
                mIntegerNumber(); 

                }
                break;
            case 33 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:328: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 34 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:339: String
                {
                mString(); 

                }
                break;
            case 35 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:346: DateTimeWithTimeZone
                {
                mDateTimeWithTimeZone(); 

                }
                break;
            case 36 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:367: Space
                {
                mSpace(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA1_eotS =
        "\12\uffff";
    static final String DFA1_eofS =
        "\12\uffff";
    static final String DFA1_minS =
        "\1\146\1\uffff\1\150\2\uffff\1\141\4\uffff";
    static final String DFA1_maxS =
        "\1\167\1\uffff\1\165\2\uffff\1\165\4\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\5\1\uffff\1\2\1\4\1\6\1\7";
    static final String DFA1_specialS =
        "\12\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\4\6\uffff\1\1\5\uffff\1\5\1\2\2\uffff\1\3",
            "",
            "\1\7\14\uffff\1\6",
            "",
            "",
            "\1\10\23\uffff\1\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "154:1: DayOfWeek : ( 'mon' | 'tue' | 'wed' | 'thu' | 'fri' | 'sat' | 'sun' );";
        }
    }
    static final String DFA12_eotS =
        "\1\uffff\4\24\1\44\2\uffff\5\24\1\uffff\3\24\6\uffff\15\24\1\uffff"+
        "\1\24\1\44\1\uffff\13\24\2\117\6\24\2\117\2\24\1\117\1\130\1\44"+
        "\2\117\1\133\3\24\1\137\2\24\1\142\3\24\1\uffff\3\24\2\151\1\24"+
        "\1\153\1\24\1\uffff\1\155\1\44\1\uffff\3\24\1\uffff\2\24\1\uffff"+
        "\4\24\1\171\1\24\1\uffff\1\24\1\uffff\1\24\1\uffff\1\44\1\uffff"+
        "\11\24\1\uffff\14\24\1\uffff\3\24\1\u0097\1\24\1\u0099\6\24\1\u00a0"+
        "\1\24\1\u00a2\1\24\1\uffff\1\u00a4\1\uffff\1\u00a5\1\u00a6\1\uffff"+
        "\1\24\1\u00a8\1\24\1\uffff\1\24\1\uffff\1\24\3\uffff\1\u00ad\1\uffff"+
        "\1\u00ae\1\24\1\uffff\1\u00b0\2\uffff\1\24\1\uffff\1\u00b2\1\uffff";
    static final String DFA12_eofS =
        "\u00b3\uffff";
    static final String DFA12_minS =
        "\1\11\1\141\1\143\1\141\1\145\1\56\2\uffff\1\157\1\162\1\146\1"+
        "\162\1\157\1\uffff\1\157\1\156\1\145\6\uffff\1\145\1\164\1\156\1"+
        "\141\1\164\2\141\1\155\1\145\1\165\1\163\1\162\1\144\1\uffff\1\60"+
        "\1\56\1\uffff\1\156\1\151\1\146\1\145\1\151\1\157\1\155\1\144\1"+
        "\163\1\156\1\145\2\56\1\160\1\162\1\151\2\160\1\145\2\56\2\153\6"+
        "\56\1\162\1\152\1\157\1\56\1\153\1\160\1\56\1\157\1\141\1\144\1"+
        "\uffff\1\154\1\164\1\166\2\56\1\172\1\56\1\151\1\uffff\1\56\1\55"+
        "\1\uffff\1\164\1\145\1\162\1\uffff\1\151\1\154\1\uffff\1\165\1\162"+
        "\1\165\1\145\1\56\1\145\1\uffff\1\157\1\uffff\1\156\1\uffff\1\56"+
        "\1\uffff\1\151\1\143\1\151\1\156\1\145\1\162\1\151\1\154\1\155\1"+
        "\uffff\1\40\1\156\1\147\1\155\2\164\1\147\1\164\1\143\1\157\2\145"+
        "\1\uffff\1\145\1\150\1\145\1\56\1\171\1\56\2\145\1\40\1\156\1\144"+
        "\1\156\1\56\1\157\1\56\1\144\1\uffff\1\56\1\uffff\2\56\1\uffff\1"+
        "\147\1\56\1\164\1\uffff\1\165\1\uffff\1\40\3\uffff\1\56\1\uffff"+
        "\1\56\1\162\1\uffff\1\56\2\uffff\1\163\1\uffff\1\56\1\uffff";
    static final String DFA12_maxS =
        "\1\175\1\165\1\163\1\165\1\157\1\172\2\uffff\1\157\1\162\1\166"+
        "\1\162\1\157\1\uffff\1\157\1\156\1\145\6\uffff\1\150\1\164\1\160"+
        "\1\141\1\164\2\141\1\155\1\145\1\165\1\163\1\162\1\144\1\uffff\1"+
        "\71\1\172\1\uffff\1\156\1\151\1\146\1\145\2\157\1\155\1\144\1\163"+
        "\1\156\1\145\2\172\1\160\1\162\1\151\2\160\1\145\2\172\2\153\6\172"+
        "\1\162\1\152\1\157\1\172\1\153\1\160\1\172\1\157\1\141\1\144\1\uffff"+
        "\1\154\1\164\1\166\4\172\1\151\1\uffff\2\172\1\uffff\1\164\1\145"+
        "\1\162\1\uffff\1\151\1\154\1\uffff\1\165\1\162\1\165\1\145\1\172"+
        "\1\145\1\uffff\1\157\1\uffff\1\156\1\uffff\1\172\1\uffff\1\151\1"+
        "\143\1\151\1\156\1\145\1\162\1\151\1\154\1\155\1\uffff\1\40\1\156"+
        "\1\147\1\155\2\164\1\147\1\164\1\143\1\157\1\151\1\145\1\uffff\1"+
        "\145\1\150\1\145\1\172\1\171\1\172\2\145\1\40\1\156\1\144\1\156"+
        "\1\172\1\157\1\172\1\144\1\uffff\1\172\1\uffff\2\172\1\uffff\1\147"+
        "\1\172\1\164\1\uffff\1\165\1\uffff\1\163\3\uffff\1\172\1\uffff\1"+
        "\172\1\162\1\uffff\1\172\2\uffff\1\163\1\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\6\uffff\1\6\1\7\5\uffff\1\14\3\uffff\1\33\1\34\1\35\1\41\1\42"+
        "\1\44\15\uffff\1\40\2\uffff\1\5\47\uffff\1\10\10\uffff\1\36\2\uffff"+
        "\1\11\3\uffff\1\32\2\uffff\1\22\6\uffff\1\24\1\uffff\1\26\1\uffff"+
        "\1\37\1\uffff\1\43\11\uffff\1\21\14\uffff\1\2\20\uffff\1\31\1\uffff"+
        "\1\13\2\uffff\1\1\3\uffff\1\3\1\uffff\1\15\1\uffff\1\17\1\20\1\27"+
        "\1\uffff\1\25\2\uffff\1\12\1\uffff\1\23\1\16\1\uffff\1\30\1\uffff"+
        "\1\4";
    static final String DFA12_specialS =
        "\u00b3\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\26\2\uffff\1\26\22\uffff\1\26\1\uffff\1\25\10\uffff\1\15"+
            "\1\7\1\23\1\24\1\uffff\12\5\1\6\6\uffff\32\24\6\uffff\1\2\1"+
            "\14\1\16\1\24\1\17\1\11\6\24\1\10\1\24\1\12\1\13\1\24\1\20\1"+
            "\1\1\3\2\24\1\4\3\24\1\21\1\uffff\1\22",
            "\1\30\1\uffff\1\27\20\uffff\1\32\1\31",
            "\1\33\10\uffff\1\35\6\uffff\1\34",
            "\1\41\6\uffff\1\40\1\36\13\uffff\1\37",
            "\1\43\11\uffff\1\42",
            "\1\45\1\uffff\12\46\1\47\6\uffff\32\24\6\uffff\32\24",
            "",
            "",
            "\1\50",
            "\1\51",
            "\1\52\17\uffff\1\53",
            "\1\54",
            "\1\55",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\61\2\uffff\1\62",
            "\1\63",
            "\1\64\1\uffff\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "",
            "\12\100",
            "\1\45\1\uffff\12\101\1\47\6\uffff\32\24\6\uffff\32\24",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\107\1\110\4\uffff\1\106",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\126",
            "\1\127",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\24\1\uffff\12\100\7\uffff\32\24\6\uffff\7\24\1\131\22\24",
            "\1\45\1\uffff\12\132\1\47\6\uffff\32\24\6\uffff\32\24",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\140",
            "\1\141",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\143",
            "\1\144",
            "\1\145",
            "",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\152",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\154",
            "",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\157\1\45\1\uffff\12\156\1\47\6\uffff\32\24\6\uffff\32\24",
            "",
            "\1\160",
            "\1\161",
            "\1\162",
            "",
            "\1\163",
            "\1\164",
            "",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\172",
            "",
            "\1\173",
            "",
            "\1\174",
            "",
            "\1\45\1\uffff\12\156\1\47\6\uffff\32\24\6\uffff\32\24",
            "",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0091\3\uffff\1\u0090",
            "\1\u0092",
            "",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\10\24\1\u0096\21"+
            "\24",
            "\1\u0098",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\u00a1",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\u00a3",
            "",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
            "\1\u00a7",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\u00a9",
            "",
            "\1\u00aa",
            "",
            "\1\u00ab\122\uffff\1\u00ac",
            "",
            "",
            "",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\u00af",
            "",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
            "",
            "\1\u00b1",
            "",
            "\1\24\1\uffff\12\24\7\uffff\32\24\6\uffff\32\24",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ScenarioPart1 | ScenarioPart2 | TimeZone | Workinghours | Time | Colon | Comma | DayOfWeek | Off | ProjectIdPrj | Booking | Plus | Overtime | Supplement | Priority | Complete | Start | End | Scheduling | SchedulingType | Scheduled | Task | Resource | Projectids | Project | Prj | OpenParen | CloseParen | Hyphen | FloatingPointNumber | FloatingPointNumberDuration | IntegerNumber | Identifier | String | DateTimeWithTimeZone | Space );";
        }
    }
 

}