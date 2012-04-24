package com.codesorcerers.auraview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

public class AuraView extends View {

	private int left;
	private int top;
	private int right;
	private int bottom;
	private int color;
	private int strokeWidth;
	private float round;
	private final Paint mPaint = new Paint();

	public AuraView(Context context, int left, int top, int right, int bottom,
			int color, int strokeWidth, float round) {
		super(context);
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.color = color;
		this.strokeWidth = strokeWidth;
		this.round = round;
		this.setVisibility(View.INVISIBLE); // originally the aura view is invisible
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getStrokeWidth() {
		return strokeWidth;
	}

	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		RectF rect = new RectF();
		
		rect.set(left, top, right, bottom);
		mPaint.setColor(color);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeWidth(strokeWidth);
		mPaint.setShader(new RadialGradient(left + (right - left)/2, top + (bottom - top)/2, bottom + top, Color.WHITE, Color.TRANSPARENT, Shader.TileMode.MIRROR));
		mPaint.setDither(true);
		canvas.drawRoundRect(rect, round, round, mPaint);
	}

}
