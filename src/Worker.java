public class Worker {

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
        private OnTaskDoneListener callback;
        private OnTaskErrorListener errorCallback;


        public Worker(OnTaskDoneListener callback) {
            this.callback = callback;
       }
    public Worker(OnTaskErrorListener errorCallback) {
            this.errorCallback = errorCallback;
    }
        public void start() {
           for (int i = 0; i < 100; i++) {
                callback.onDone("Task " + i + " is done");
                if (i == 33) {
                    errorCallback.onError("Task " + i + " is error");
                }
            }
        }

}
