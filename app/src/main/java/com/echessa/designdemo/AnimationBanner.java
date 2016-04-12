package com.echessa.designdemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class AnimationBanner extends FrameLayout {

    private Context mContext;


    private int bannerNum;


    private int mDuration = 500;

    private int mCurrentBannerIndex = 0;


    private OnBannerClickListener mListener;


    private List<ImageView> mImageViews;


    private List<PointIndicator> mIndicators;


    private int mIndicatorPosition = IndicatorPosition.RIGHT_BOTTOM;


    private int mRadius = 10;


    private int mSelectedColor = Color.WHITE;

    private int mUnSelectedColor = Color.GRAY;


    private boolean isOnlyOne = false;


    private boolean isAnimationing = false;


    private boolean isAutoSwitch = false;


    private ObjectAnimator autoAnimator;


    private float firstX = 0;
    private float firstY = 0;


    private static final int DISTANCE_THRESHOLD = 30;

    public AnimationBanner(Context context) {
        this(context, null);
    }

    public AnimationBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void initView() {
        if (bannerNum <= 0) {
            return;
        }

        if (bannerNum == 1) {
            isOnlyOne = true;
        }

        LinearLayout mBannerContainer = getBannerContainer();
        if (mBannerContainer != null) {
            addView(mBannerContainer);
        }


        LinearLayout mIndicatorContainer = getIndicatorContainer();
        if (mIndicatorContainer != null) {
            addView(mIndicatorContainer);
        }


        setClickable(true);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
             int action = event.getAction();
        float currentX, currentY;

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                firstX = event.getX();
                firstY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                currentX = event.getX();
                currentY = event.getY();
                if (Math.abs(currentX - firstX) > Math.abs(currentY - firstY)) {
                    if (!isOnlyOne) {
                        if (currentX - firstX > 0) {
                                if (!isAnimationing) {
                                doRightAnimation();
                            }
                        } else {

                            if (!isAnimationing) {
                                doLeftAnimation();
                            }
                        }
                    }
                } else if (Math.abs(currentX - firstX) < DISTANCE_THRESHOLD && Math.abs(currentY - firstY) < DISTANCE_THRESHOLD) {

                    if (mListener != null) {
                        if (!isAnimationing) {
                            mListener.onClick(mCurrentBannerIndex);
                        }
                    }
                }
                break;
            default:
                break;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        return true;
    }


    private LinearLayout getBannerContainer() {
        mImageViews = new ArrayList<>();
        LinearLayout mBannerContainer = new LinearLayout(mContext);
        mBannerContainer.setOrientation(LinearLayout.HORIZONTAL);
        mBannerContainer.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mBannerContainer.removeAllViews();

        for (int i = 0; i < bannerNum; i++) {
            ImageView imageView = new ImageView(mContext);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(getScreenWidth(), LinearLayout.LayoutParams.WRAP_CONTENT));
            mBannerContainer.addView(imageView);
            mImageViews.add(imageView);
        }

        return mBannerContainer;
    }


    private LinearLayout getIndicatorContainer() {
        if (isOnlyOne) {
            return null;
        }

        mIndicators = new ArrayList<>();
        LinearLayout mIndicatorContainer = new LinearLayout(mContext);
        mIndicatorContainer.setOrientation(LinearLayout.HORIZONTAL);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        switch (mIndicatorPosition) {
            case IndicatorPosition.CENTER_BOTTOM:
                params.gravity = Gravity.CENTER | Gravity.BOTTOM;
                break;
            case IndicatorPosition.LEFT_BOTTOM:
                params.gravity = Gravity.LEFT | Gravity.BOTTOM;
                break;
            case IndicatorPosition.RIGHT_BOTTOM:
                params.gravity = Gravity.RIGHT | Gravity.BOTTOM;
                break;
            default:
                break;
        }
        mIndicatorContainer.setLayoutParams(params);
        mIndicatorContainer.setPadding(50, 30, 50, 30);
        mIndicatorContainer.removeAllViews();

        for (int i = 0; i < bannerNum; i++) {
            PointIndicator indicator;
            if (i == 0) {
                indicator = new PointIndicator(mContext, mRadius, mSelectedColor);
                indicator.setLayoutParams(new LinearLayout.LayoutParams(mRadius * 3, mRadius * 2));
            } else {
                indicator = new PointIndicator(mContext, mRadius, mUnSelectedColor);
                indicator.setLayoutParams(new LinearLayout.LayoutParams(mRadius * 3, mRadius * 2));
            }
            mIndicatorContainer.addView(indicator);
            mIndicators.add(indicator);
        }

        return mIndicatorContainer;
    }


    public void setAnimDuration(int millisecond) {
        mDuration = millisecond;
    }


    public void setBannerNum(int num) {
        bannerNum = num;
    }


    public void setIndicatorPosition(int position) {
        mIndicatorPosition = position;
    }


    public void setIndicatorRaidus(int radius) {
        mRadius = radius;
    }


    public void setSelectedColor(int selectedColor) {
        mSelectedColor = selectedColor;
    }


    public void setUnSelectedColor(int unSelectedColor) {
        mUnSelectedColor = unSelectedColor;
    }


    public void setBannerSize(double ratio, int bannerWidth) {
        if (mImageViews == null || mImageViews.size() <= 0) {
            return;
        }

        if (ratio > 0 && bannerWidth > 0) {
            int bannerHeight = (int) (bannerWidth / ratio);
            for (ImageView imageView : mImageViews) {
                imageView.getLayoutParams().width = bannerWidth;
                imageView.getLayoutParams().height = bannerHeight;
            }
            getLayoutParams().width = bannerWidth;
        }
    }



    public void setBannerSize(double ratio) {
        int defaultBannerWidth = getScreenWidth();
        setBannerSize(ratio, defaultBannerWidth);
    }


    public void setOnBannerClickListener(OnBannerClickListener listener) {
        this.mListener = listener;
    }



    public List<ImageView> getBannerImageViews() {
        if (mImageViews != null) {
            return mImageViews;
        }

        return null;
    }


    private int getScreenWidth() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(metrics);

        return metrics.widthPixels;
    }


    private void doLeftAnimation() {
        if (mCurrentBannerIndex == bannerNum - 1) {
            mCurrentBannerIndex = 0;
        } else {
            mCurrentBannerIndex += 1;
        }

        for (int i = 0; i < bannerNum; i++) {
            doLeftAnimation(mImageViews.get(i), i);
        }
    }


    private void doLeftAnimation(final View v, final int index) {
        ObjectAnimator leftAnimator = ObjectAnimator.ofFloat(v, "x", v.getX(), v.getX() - v.getWidth());
        leftAnimator.setDuration(mDuration);
        leftAnimator.setInterpolator(new LinearInterpolator());
        leftAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isAnimationing = false;
                if (index == bannerNum - 1) {

                    mIndicators.get(mCurrentBannerIndex).changeStatus(true);
                    if (mCurrentBannerIndex != 0) {
                        mIndicators.get(mCurrentBannerIndex - 1).changeStatus(false);
                    } else {
                        mIndicators.get(bannerNum - 1).changeStatus(false);
                    }
                }


                if (v.getX() < 0) {
                    v.setX((bannerNum - 1) * v.getWidth());
                }
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationStart(Animator animation) {
                isAnimationing = true;
            }
        });
        leftAnimator.start();
    }


    private void doRightAnimation() {
        if (mCurrentBannerIndex == 0) {
            mCurrentBannerIndex = bannerNum - 1;
        } else {
            mCurrentBannerIndex -= 1;
        }


        for (int i = 0; i < bannerNum; i++) {
            if (mImageViews.get(i).getX() == mImageViews.get(i).getWidth() * (bannerNum - 1)) {
                mImageViews.get(i).setX(-mImageViews.get(i).getWidth());
                break;
            }
        }

        for (int i = 0; i < bannerNum; i++) {
            doRightAnimation(mImageViews.get(i), i);
        }
    }


    private void doRightAnimation(final View v, final int index) {
        ObjectAnimator rightAnimator = ObjectAnimator.ofFloat(v, "x", v.getX(), v.getX() + v.getWidth());
        rightAnimator.setDuration(mDuration);
        rightAnimator.setInterpolator(new LinearInterpolator());
        rightAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isAnimationing = false;
                if (index == bannerNum - 1) {

                    mIndicators.get(mCurrentBannerIndex).changeStatus(true);
                    if (mCurrentBannerIndex != bannerNum - 1) {
                        mIndicators.get(mCurrentBannerIndex + 1).changeStatus(false);
                    } else {
                        mIndicators.get(0).changeStatus(false);
                    }
                }
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationStart(Animator animation) {
                isAnimationing = true;
            }
        });
        rightAnimator.start();
    }


    public void startAutoPlay() {
        if (isAutoSwitch && !isOnlyOne) {
            for (int i = 0; i < bannerNum; i++) {
                doAutoAnimation(mImageViews.get(i));
            }
        }
    }


    public void stopAutoPlay() {
        if (autoAnimator != null) {
            autoAnimator.cancel();
        }
    }


    public void doAutoAnimation(final View v) {
        autoAnimator = ObjectAnimator.ofFloat(v, "x", v.getX(), v.getX() - v.getWidth());
        autoAnimator.setDuration(mDuration * 3);
        autoAnimator.setInterpolator(new LinearInterpolator());
        autoAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (v.getX() < 0) {
                    v.setX((bannerNum - 1) * v.getWidth());
                }

                doAutoAnimation(v);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationStart(Animator animation) {

            }
        });
        autoAnimator.start();
    }


    public final class IndicatorPosition {
        public static final int RIGHT_BOTTOM = 0;
        public static final int LEFT_BOTTOM = 1;
        public static final int CENTER_BOTTOM = 2;
    }


    public interface OnBannerClickListener {
        void onClick(int bannerIndex);
    }


    public class PointIndicator extends View {
        private Paint mPaint;
        private int mRadius;
        private int mColor;

        public PointIndicator(Context context, int radius, int color) {
            super(context);
            this.mRadius = radius;
            this.mColor = color;
            initPaint();
        }

        public void initPaint() {
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(mColor);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawCircle(mRadius + mRadius / 2, mRadius, mRadius, mPaint);
        }


        public void changeStatus(boolean isCurrent) {
            if (isCurrent) {
                mColor = mSelectedColor;
                initPaint();
                invalidate();
            } else {
                mColor = mUnSelectedColor;
                initPaint();
                invalidate();
            }
        }
    }

}
