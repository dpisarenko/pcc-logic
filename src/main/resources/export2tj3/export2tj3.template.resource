
resource R${resourceId} "${abbreviation}"
{
	limits { dailymax ${dailyLimitInHours}h }
}
