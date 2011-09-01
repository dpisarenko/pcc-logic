// $ANTLR 3.2 Sep 23, 2009 14:05:07 src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g 2011-09-02 01:37:16

package at.silverstrike.pcc.impl.tj3bookingsparser.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BookingsLexer extends Lexer {
    public static final int D=38;
    public static final int End=19;
    public static final int Scheduled=22;
    public static final int FloatingPointNumberDuration=34;
    public static final int Start=18;
    public static final int A=13;
    public static final int Prj=5;
    public static final int CloseParen=10;
    public static final int IntegerNumber=25;
    public static final int Supplement=23;
    public static final int H=40;
    public static final int DayOfWeek=27;
    public static final int DateTimeWithTimeZone=7;
    public static final int Utc=12;
    public static final int Time=30;
    public static final int Colon=31;
    public static final int P=39;
    public static final int EOF=-1;
    public static final int Project=4;
    public static final int FloatingPointNumber=35;
    public static final int TimeZone=11;
    public static final int Identifier=16;
    public static final int Space=41;
    public static final int Resource=15;
    public static final int Hyphen=8;
    public static final int Plus=33;
    public static final int Off=28;
    public static final int Overtime=36;
    public static final int OpenParen=9;
    public static final int Booking=32;
    public static final int Priority=24;
    public static final int Projectids=14;
    public static final int Scheduling=20;
    public static final int String=6;
    public static final int Task=17;
    public static final int Asap=21;
    public static final int Comma=29;
    public static final int Workinghours=26;
    public static final int Complete=37;

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

    // $ANTLR start "TimeZone"
    public final void mTimeZone() throws RecognitionException {
        try {
            int _type = TimeZone;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:64:2: ( 'timezone' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:65:2: 'timezone'
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

    // $ANTLR start "Utc"
    public final void mUtc() throws RecognitionException {
        try {
            int _type = Utc;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:69:2: ( '\"' ( A )+ '\"' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:70:2: '\"' ( A )+ '\"'
            {
            match('\"'); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:70:5: ( A )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:70:5: A
            	    {
            	    mA(); 

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

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Utc"

    // $ANTLR start "Workinghours"
    public final void mWorkinghours() throws RecognitionException {
        try {
            int _type = Workinghours;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:121:2: ( 'workinghours' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:121:4: 'workinghours'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:134:2: ( IntegerNumber Colon IntegerNumber )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:134:4: IntegerNumber Colon IntegerNumber
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:138:2: ( ':' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:139:2: ':'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:143:2: ( ',' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:144:2: ','
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:148:2: ( 'mon' | 'tue' | 'wed' | 'thu' | 'fri' | 'sat' | 'sun' )
            int alt2=7;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:148:4: 'mon'
                    {
                    match("mon"); 


                    }
                    break;
                case 2 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:149:4: 'tue'
                    {
                    match("tue"); 


                    }
                    break;
                case 3 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:150:4: 'wed'
                    {
                    match("wed"); 


                    }
                    break;
                case 4 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:151:4: 'thu'
                    {
                    match("thu"); 


                    }
                    break;
                case 5 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:152:4: 'fri'
                    {
                    match("fri"); 


                    }
                    break;
                case 6 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:153:4: 'sat'
                    {
                    match("sat"); 


                    }
                    break;
                case 7 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:154:4: 'sun'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:158:2: ( 'off' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:159:2: 'off'
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

    // $ANTLR start "Booking"
    public final void mBooking() throws RecognitionException {
        try {
            int _type = Booking;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:188:2: ( 'booking' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:189:2: 'booking'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:193:2: ( '+' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:194:2: '+'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:208:2: ( 'overtime' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:209:2: 'overtime'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:213:2: ( 'supplement' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:214:2: 'supplement'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:218:2: ( 'priority' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:219:2: 'priority'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:223:2: ( 'complete' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:224:2: 'complete'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:228:2: ( 'start' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:229:2: 'start'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:233:2: ( 'end' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:234:2: 'end'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:238:2: ( 'scheduling' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:239:2: 'scheduling'
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

    // $ANTLR start "Asap"
    public final void mAsap() throws RecognitionException {
        try {
            int _type = Asap;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:243:2: ( 'asap' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:244:2: 'asap'
            {
            match("asap"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Asap"

    // $ANTLR start "Scheduled"
    public final void mScheduled() throws RecognitionException {
        try {
            int _type = Scheduled;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:248:2: ( 'scheduled' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:249:2: 'scheduled'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:253:2: ( 'task' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:254:2: 'task'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:258:2: ( 'resource' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:259:2: 'resource'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:263:2: ( 'projectids' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:264:2: 'projectids'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:268:3: ( 'project' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:268:6: 'project'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:272:3: ( 'prj' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:272:6: 'prj'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:276:3: ( '{' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:276:6: '{'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:280:3: ( '}' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:280:6: '}'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:284:3: ( '-' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:284:6: '-'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:288:3: ( ( D )+ '.' ( D )+ )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:288:5: ( D )+ '.' ( D )+
            {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:288:5: ( D )+
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
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:288:5: D
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:288:10: ( D )+
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
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:288:10: D
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:291:3: ( ( D )+ P ( D )+ H )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:291:5: ( D )+ P ( D )+ H
            {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:291:5: ( D )+
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
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:291:5: D
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:291:10: ( D )+
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
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:291:10: D
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:295:3: ( ( D )+ )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:295:5: ( D )+
            {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:295:5: ( D )+
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
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:295:5: D
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:299:3: ( ( D | A | P )+ )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:299:5: ( D | A | P )+
            {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:299:5: ( D | A | P )+
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:302:3: ( '\"' (~ '\"' )* '\"' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:302:6: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:302:10: (~ '\"' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:302:10: ~ '\"'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:306:3: ( D D D D '-' D D '-' D D '-' D D ':' D D '-+' D D D D )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:306:6: D D D D '-' D D '-' D D '-' D D ':' D D '-+' D D D D
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:311:3: ( '0' .. '9' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:311:6: '0' .. '9'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:316:3: ( 'A' .. 'Z' | 'a' .. 'z' )
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:322:3: ( '.' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:322:5: '.'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:327:3: ( 'h' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:327:5: 'h'
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
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:332:3: ( ( ' ' | '\\t' | ( '\\r' )? '\\n' ) )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:332:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )
            {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:332:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )
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
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:332:7: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:332:13: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 3 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:332:20: ( '\\r' )? '\\n'
                    {
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:332:20: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:332:20: '\\r'
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
        // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:8: ( TimeZone | Utc | Workinghours | Time | Colon | Comma | DayOfWeek | Off | Booking | Plus | Overtime | Supplement | Priority | Complete | Start | End | Scheduling | Asap | Scheduled | Task | Resource | Projectids | Project | Prj | OpenParen | CloseParen | Hyphen | FloatingPointNumber | FloatingPointNumberDuration | IntegerNumber | Identifier | String | DateTimeWithTimeZone | Space )
        int alt12=34;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:10: TimeZone
                {
                mTimeZone(); 

                }
                break;
            case 2 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:19: Utc
                {
                mUtc(); 

                }
                break;
            case 3 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:23: Workinghours
                {
                mWorkinghours(); 

                }
                break;
            case 4 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:36: Time
                {
                mTime(); 

                }
                break;
            case 5 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:41: Colon
                {
                mColon(); 

                }
                break;
            case 6 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:47: Comma
                {
                mComma(); 

                }
                break;
            case 7 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:53: DayOfWeek
                {
                mDayOfWeek(); 

                }
                break;
            case 8 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:63: Off
                {
                mOff(); 

                }
                break;
            case 9 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:67: Booking
                {
                mBooking(); 

                }
                break;
            case 10 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:75: Plus
                {
                mPlus(); 

                }
                break;
            case 11 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:80: Overtime
                {
                mOvertime(); 

                }
                break;
            case 12 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:89: Supplement
                {
                mSupplement(); 

                }
                break;
            case 13 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:100: Priority
                {
                mPriority(); 

                }
                break;
            case 14 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:109: Complete
                {
                mComplete(); 

                }
                break;
            case 15 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:118: Start
                {
                mStart(); 

                }
                break;
            case 16 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:124: End
                {
                mEnd(); 

                }
                break;
            case 17 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:128: Scheduling
                {
                mScheduling(); 

                }
                break;
            case 18 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:139: Asap
                {
                mAsap(); 

                }
                break;
            case 19 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:144: Scheduled
                {
                mScheduled(); 

                }
                break;
            case 20 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:154: Task
                {
                mTask(); 

                }
                break;
            case 21 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:159: Resource
                {
                mResource(); 

                }
                break;
            case 22 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:168: Projectids
                {
                mProjectids(); 

                }
                break;
            case 23 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:179: Project
                {
                mProject(); 

                }
                break;
            case 24 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:187: Prj
                {
                mPrj(); 

                }
                break;
            case 25 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:191: OpenParen
                {
                mOpenParen(); 

                }
                break;
            case 26 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:201: CloseParen
                {
                mCloseParen(); 

                }
                break;
            case 27 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:212: Hyphen
                {
                mHyphen(); 

                }
                break;
            case 28 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:219: FloatingPointNumber
                {
                mFloatingPointNumber(); 

                }
                break;
            case 29 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:239: FloatingPointNumberDuration
                {
                mFloatingPointNumberDuration(); 

                }
                break;
            case 30 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:267: IntegerNumber
                {
                mIntegerNumber(); 

                }
                break;
            case 31 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:281: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 32 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:292: String
                {
                mString(); 

                }
                break;
            case 33 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:299: DateTimeWithTimeZone
                {
                mDateTimeWithTimeZone(); 

                }
                break;
            case 34 :
                // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:1:320: Space
                {
                mSpace(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA2_eotS =
        "\12\uffff";
    static final String DFA2_eofS =
        "\12\uffff";
    static final String DFA2_minS =
        "\1\146\1\uffff\1\150\2\uffff\1\141\4\uffff";
    static final String DFA2_maxS =
        "\1\167\1\uffff\1\165\2\uffff\1\165\4\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\5\1\uffff\1\2\1\4\1\6\1\7";
    static final String DFA2_specialS =
        "\12\uffff}>";
    static final String[] DFA2_transitionS = {
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

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "147:1: DayOfWeek : ( 'mon' | 'tue' | 'wed' | 'thu' | 'fri' | 'sat' | 'sun' );";
        }
    }
    static final String DFA12_eotS =
        "\1\uffff\1\25\1\uffff\1\25\1\37\2\uffff\5\25\1\uffff\5\25\5\uffff"+
        "\4\25\2\uffff\2\25\1\uffff\1\25\1\37\1\uffff\17\25\2\114\1\25\1"+
        "\uffff\1\25\1\114\1\120\1\37\4\114\3\25\1\126\4\25\1\133\1\25\1"+
        "\135\3\25\1\uffff\1\141\1\uffff\1\25\1\uffff\1\143\1\37\3\25\1\uffff"+
        "\4\25\1\uffff\1\25\1\uffff\1\156\2\25\1\uffff\1\25\1\uffff\1\37"+
        "\1\uffff\1\25\1\163\6\25\1\uffff\4\25\1\uffff\14\25\1\u008b\1\25"+
        "\1\u008e\2\25\1\u0091\4\25\1\u0096\1\uffff\1\u0097\1\25\1\uffff"+
        "\1\u0099\1\u009a\1\uffff\3\25\1\u009e\2\uffff\1\25\2\uffff\1\25"+
        "\1\u00a1\1\u00a2\1\uffff\1\u00a3\1\25\3\uffff\1\u00a5\1\uffff";
    static final String DFA12_eofS =
        "\u00a6\uffff";
    static final String DFA12_minS =
        "\1\11\1\141\1\0\1\145\1\56\2\uffff\1\157\1\162\1\141\1\146\1\157"+
        "\1\uffff\1\162\1\157\1\156\1\163\1\145\5\uffff\1\155\1\145\1\165"+
        "\1\163\1\0\1\uffff\1\162\1\144\1\uffff\1\60\1\56\1\uffff\1\156\1"+
        "\151\1\164\1\156\1\141\1\150\1\146\1\145\1\157\1\151\1\155\1\144"+
        "\1\141\1\163\1\145\2\56\1\153\1\uffff\1\153\7\56\1\160\1\162\1\145"+
        "\1\56\1\162\1\153\1\157\1\152\1\56\1\160\1\56\1\160\1\157\1\172"+
        "\1\uffff\1\56\1\uffff\1\151\1\uffff\1\56\1\55\1\154\1\164\1\144"+
        "\1\uffff\1\164\1\151\1\162\1\145\1\uffff\1\154\1\uffff\1\56\1\165"+
        "\1\157\1\uffff\1\156\1\uffff\1\56\1\uffff\1\145\1\56\1\165\1\151"+
        "\1\156\1\151\1\143\1\145\1\uffff\1\162\1\156\1\147\1\155\1\uffff"+
        "\1\154\1\155\1\147\3\164\1\143\1\145\1\150\3\145\1\56\1\171\1\56"+
        "\2\145\1\56\1\157\2\156\1\144\1\56\1\uffff\1\56\1\144\1\uffff\2"+
        "\56\1\uffff\1\165\1\164\1\147\1\56\2\uffff\1\163\2\uffff\1\162\2"+
        "\56\1\uffff\1\56\1\163\3\uffff\1\56\1\uffff";
    static final String DFA12_maxS =
        "\1\175\1\165\1\uffff\1\157\1\172\2\uffff\1\157\1\162\1\165\1\166"+
        "\1\157\1\uffff\1\162\1\157\1\156\1\163\1\145\5\uffff\1\155\1\145"+
        "\1\165\1\163\1\uffff\1\uffff\1\162\1\144\1\uffff\1\71\1\172\1\uffff"+
        "\1\156\1\151\1\164\1\160\1\141\1\150\1\146\1\145\2\157\1\155\1\144"+
        "\1\141\1\163\1\145\2\172\1\153\1\uffff\1\153\7\172\1\160\1\162\1"+
        "\145\1\172\1\162\1\153\1\157\1\152\1\172\1\160\1\172\1\160\1\157"+
        "\1\172\1\uffff\1\172\1\uffff\1\151\1\uffff\2\172\1\154\1\164\1\144"+
        "\1\uffff\1\164\1\151\1\162\1\145\1\uffff\1\154\1\uffff\1\172\1\165"+
        "\1\157\1\uffff\1\156\1\uffff\1\172\1\uffff\1\145\1\172\1\165\1\151"+
        "\1\156\1\151\1\143\1\145\1\uffff\1\162\1\156\1\147\1\155\1\uffff"+
        "\1\154\1\155\1\147\3\164\1\143\1\145\1\150\1\145\1\151\1\145\1\172"+
        "\1\171\1\172\2\145\1\172\1\157\2\156\1\144\1\172\1\uffff\1\172\1"+
        "\144\1\uffff\2\172\1\uffff\1\165\1\164\1\147\1\172\2\uffff\1\163"+
        "\2\uffff\1\162\2\172\1\uffff\1\172\1\163\3\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\5\uffff\1\5\1\6\5\uffff\1\12\5\uffff\1\31\1\32\1\33\1\37\1\42"+
        "\5\uffff\1\40\2\uffff\1\36\2\uffff\1\4\22\uffff\1\2\26\uffff\1\7"+
        "\1\uffff\1\2\1\uffff\1\34\5\uffff\1\10\4\uffff\1\30\1\uffff\1\20"+
        "\3\uffff\1\24\1\uffff\1\35\1\uffff\1\41\10\uffff\1\22\4\uffff\1"+
        "\17\27\uffff\1\11\2\uffff\1\27\2\uffff\1\1\4\uffff\1\13\1\15\1\uffff"+
        "\1\16\1\25\3\uffff\1\23\2\uffff\1\14\1\21\1\26\1\uffff\1\3";
    static final String DFA12_specialS =
        "\2\uffff\1\1\30\uffff\1\0\u008a\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\26\2\uffff\1\26\22\uffff\1\26\1\uffff\1\2\10\uffff\1\14"+
            "\1\6\1\24\1\25\1\uffff\12\4\1\5\6\uffff\32\25\6\uffff\1\20\1"+
            "\13\1\16\1\25\1\17\1\10\6\25\1\7\1\25\1\12\1\15\1\25\1\21\1"+
            "\11\1\1\2\25\1\3\3\25\1\22\1\uffff\1\23",
            "\1\32\6\uffff\1\31\1\27\13\uffff\1\30",
            "\101\34\32\33\6\34\32\33\uff85\34",
            "\1\36\11\uffff\1\35",
            "\1\40\1\uffff\12\41\1\42\6\uffff\32\25\6\uffff\32\25",
            "",
            "",
            "\1\43",
            "\1\44",
            "\1\45\1\uffff\1\50\20\uffff\1\47\1\46",
            "\1\51\17\uffff\1\52",
            "\1\53",
            "",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "",
            "",
            "",
            "",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\42\34\1\65\36\34\32\33\6\34\32\33\uff85\34",
            "",
            "\1\66",
            "\1\67",
            "",
            "\12\70",
            "\1\40\1\uffff\12\71\1\42\6\uffff\32\25\6\uffff\32\25",
            "",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75\1\uffff\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104\1\106\4\uffff\1\105",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\115",
            "",
            "\1\117",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\25\1\uffff\12\70\7\uffff\32\25\6\uffff\7\25\1\121\22\25",
            "\1\40\1\uffff\12\122\1\42\6\uffff\32\25\6\uffff\32\25",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\134",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\136",
            "\1\137",
            "\1\140",
            "",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "",
            "\1\142",
            "",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\145\1\40\1\uffff\12\144\1\42\6\uffff\32\25\6\uffff\32\25",
            "\1\146",
            "\1\147",
            "\1\150",
            "",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "",
            "\1\155",
            "",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\157",
            "\1\160",
            "",
            "\1\161",
            "",
            "\1\40\1\uffff\12\144\1\42\6\uffff\32\25\6\uffff\32\25",
            "",
            "\1\162",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0089\3\uffff\1\u0088",
            "\1\u008a",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\u008c",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\10\25\1\u008d\21"+
            "\25",
            "\1\u008f",
            "\1\u0090",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\u0098",
            "",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "",
            "",
            "\1\u009f",
            "",
            "",
            "\1\u00a0",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\1\u00a4",
            "",
            "",
            "",
            "\1\25\1\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
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
            return "1:1: Tokens : ( TimeZone | Utc | Workinghours | Time | Colon | Comma | DayOfWeek | Off | Booking | Plus | Overtime | Supplement | Priority | Complete | Start | End | Scheduling | Asap | Scheduled | Task | Resource | Projectids | Project | Prj | OpenParen | CloseParen | Hyphen | FloatingPointNumber | FloatingPointNumberDuration | IntegerNumber | Identifier | String | DateTimeWithTimeZone | Space );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_27 = input.LA(1);

                        s = -1;
                        if ( (LA12_27=='\"') ) {s = 53;}

                        else if ( ((LA12_27>='A' && LA12_27<='Z')||(LA12_27>='a' && LA12_27<='z')) ) {s = 27;}

                        else if ( ((LA12_27>='\u0000' && LA12_27<='!')||(LA12_27>='#' && LA12_27<='@')||(LA12_27>='[' && LA12_27<='`')||(LA12_27>='{' && LA12_27<='\uFFFF')) ) {s = 28;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_2 = input.LA(1);

                        s = -1;
                        if ( ((LA12_2>='A' && LA12_2<='Z')||(LA12_2>='a' && LA12_2<='z')) ) {s = 27;}

                        else if ( ((LA12_2>='\u0000' && LA12_2<='@')||(LA12_2>='[' && LA12_2<='`')||(LA12_2>='{' && LA12_2<='\uFFFF')) ) {s = 28;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}