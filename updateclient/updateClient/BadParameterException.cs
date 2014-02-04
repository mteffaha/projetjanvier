using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace updateClient 
{
    class BadParameterException : Exception
    {
        private string errorMessage;

        public BadParameterException()
        {
            errorMessage = "empty error message";
        }
        public BadParameterException(string m)
        {
            errorMessage = m;
        }
        public string getErrorMessage()
        {
            return errorMessage;
        }
    }
}
