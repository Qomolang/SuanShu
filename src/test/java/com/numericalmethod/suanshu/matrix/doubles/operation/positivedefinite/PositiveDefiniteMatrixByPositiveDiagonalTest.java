/*
 * Copyright (c) Numerical Method Inc.
 * http://www.numericalmethod.com/
 * 
 * THIS SOFTWARE IS LICENSED, NOT SOLD.
 * 
 * YOU MAY USE THIS SOFTWARE ONLY AS DESCRIBED IN THE LICENSE.
 * IF YOU ARE NOT AWARE OF AND/OR DO NOT AGREE TO THE TERMS OF THE LICENSE,
 * DO NOT USE THIS SOFTWARE.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITH NO WARRANTY WHATSOEVER,
 * EITHER EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION,
 * ANY WARRANTIES OF ACCURACY, ACCESSIBILITY, COMPLETENESS,
 * FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, NON-INFRINGEMENT, 
 * TITLE AND USEFULNESS.
 * 
 * IN NO EVENT AND UNDER NO LEGAL THEORY,
 * WHETHER IN ACTION, CONTRACT, NEGLIGENCE, TORT, OR OTHERWISE,
 * SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 * ANY CLAIMS, DAMAGES OR OTHER LIABILITIES,
 * ARISING AS A RESULT OF USING OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.numericalmethod.suanshu.matrix.doubles.operation.positivedefinite;

import com.numericalmethod.suanshu.matrix.doubles.IsMatrix;
import com.numericalmethod.suanshu.misc.SuanShuUtils;
import com.numericalmethod.suanshu.matrix.doubles.Matrix;
import com.numericalmethod.suanshu.matrix.doubles.matrixtype.dense.DenseMatrix;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Haksun Li
 */
public class PositiveDefiniteMatrixByPositiveDiagonalTest {

    @Test
    public void test_0010() {
        Matrix H1 = new DenseMatrix(new double[][]{
                    {28.9492, 0.11130, -2.384200},
                    {0.1113, 0.01710, 0.068850},
                    {-2.3842, 0.06885, 0.561433}
                });
        assertFalse(IsMatrix.positiveDefinite(H1));

        double epsilon = Math.sqrt(SuanShuUtils.autoEpsilon(H1));
        Matrix H2 = new PositiveDefiniteMatrixByPositiveDiagonal(H1, epsilon, epsilon);
        assertTrue(IsMatrix.symmetricPositiveDefinite(H2));
    }

    @Test
    public void test_0020() {
        Matrix H1 = new DenseMatrix(new double[][]{
                    {1., 0.1},
                    {0.2, 1.}
                });
        assertTrue(IsMatrix.positiveDefinite(H1));
        assertFalse(IsMatrix.symmetricPositiveDefinite(H1));

        double epsilon = Math.sqrt(SuanShuUtils.autoEpsilon(H1));
        Matrix H2 = new PositiveDefiniteMatrixByPositiveDiagonal(H1, epsilon, epsilon);
        assertTrue(IsMatrix.symmetricPositiveDefinite(H2));
    }
}
