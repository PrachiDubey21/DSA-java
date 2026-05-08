 // Calculate total sum
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // Left sum initially 0
        int leftSum = 0;

        // Traverse array
        for (int i = 0; i < nums.length; i++) {

            // Calculate right sum
            int rightSum = totalSum - leftSum - nums[i];

            // Check pivot condition
            if (leftSum == rightSum) {
                return i;
            }

            // Update left sum
            leftSum += nums[i];
        }

        // No pivot index found
        return -1;