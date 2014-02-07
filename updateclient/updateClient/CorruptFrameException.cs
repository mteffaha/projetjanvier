using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace updateClient
{
    class CorruptFrameException : Exception
    {
       private string errorMessage;
       public CorruptFrameException()
        {
            errorMessage = "empty error message";
        }
        public CorruptFrameException(string m)
        {
            errorMessage = m;
        }
        public string getErrorMessage()
        {
            return errorMessage;
        }
    }
}
